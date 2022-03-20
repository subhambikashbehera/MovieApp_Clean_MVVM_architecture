package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.movie.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

interface MovieLocalDataSource {
    suspend fun getMoviesFromDb():List<Movie>
    suspend fun clearAllFromDb()
    suspend fun updateMoviesToDb(listMovies:List<Movie>)
}