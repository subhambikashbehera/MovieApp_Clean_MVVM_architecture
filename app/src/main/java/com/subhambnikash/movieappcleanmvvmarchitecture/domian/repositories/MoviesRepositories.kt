package com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie

interface MoviesRepositories {
    suspend fun getMovies():List<Movie>?
    suspend fun updateMovies():List<Movie>?
}