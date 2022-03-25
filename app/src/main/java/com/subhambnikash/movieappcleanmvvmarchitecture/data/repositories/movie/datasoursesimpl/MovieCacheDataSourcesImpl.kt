package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieCacheDataSource

class MovieCacheDataSourcesImpl:MovieCacheDataSource {
    private var arrayListOf=ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
       return arrayListOf
    }

    override suspend fun updateMovieToCache(movieList: List<Movie>) {
       arrayListOf.clear()
       arrayListOf= ArrayList(movieList)
    }
}