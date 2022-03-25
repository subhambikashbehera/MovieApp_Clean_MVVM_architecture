package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb():List<Movie>
    suspend fun clearAllFromDb()
    suspend fun updateMoviesToDb(listMovies:List<Movie>)
}