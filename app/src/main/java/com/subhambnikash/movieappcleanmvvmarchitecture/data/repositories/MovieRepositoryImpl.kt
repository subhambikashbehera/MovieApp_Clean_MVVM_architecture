package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieCacheDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieLocalDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieOnlineDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.MoviesRepositories

class MovieRepositoryImpl(
    private val movieOnlineDataSources: MovieOnlineDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
) : MoviesRepositories {

    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie> {
        movieLocalDataSource.clearAllFromDb()
        val newListOfMovies:List<Movie> = getMoviesFromApi()
        movieLocalDataSource.updateMoviesToDb(newListOfMovies)
        movieCacheDataSource.updateMovieToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromApi():List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response =  movieOnlineDataSources.getMoviesFromApi()
            val body=response.body()
            if (body!=null)
            {
                movieList=body.movies
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return movieList
    }

    private suspend fun getMoviesFromLocalDb():List<Movie>{
        lateinit var  movieListOf:List<Movie>
        try {
            movieListOf =  movieLocalDataSource.getMoviesFromDb()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (movieListOf.isNotEmpty()){
            return movieListOf
        }else{
            movieListOf=getMoviesFromApi()
            movieLocalDataSource.updateMoviesToDb(movieListOf)
        }
        return movieListOf

    }

    private suspend fun getMoviesFromCache():List<Movie>{
        lateinit var  movieListOf:List<Movie>
        try {
            movieListOf =  movieCacheDataSource.getMoviesFromCache()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        if (movieListOf.isNotEmpty()){
            return movieListOf
        }else{
            movieListOf=getMoviesFromLocalDb()
            movieCacheDataSource.updateMovieToCache(movieListOf)
        }
        return movieListOf

    }
}