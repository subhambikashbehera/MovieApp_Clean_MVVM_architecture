package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.MoviesDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourcesImpl(private val moviesDao: MoviesDao):MovieLocalDataSource {
    override suspend fun getMoviesFromDb(): List<Movie> {
      return moviesDao.getMovie()
    }

    override suspend fun clearAllFromDb() {
        CoroutineScope(Dispatchers.IO).launch {
            moviesDao.deleteMovie()
        }
    }

    override suspend fun updateMoviesToDb(listMovies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
           moviesDao.saveMovie(listMovies)
       }
    }
}