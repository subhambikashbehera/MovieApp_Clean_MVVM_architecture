package com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

interface MoviesRepositories {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}