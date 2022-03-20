package com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.MoviesRepositories

class UpdateMoviesUseCases(private val moviesRepositories: MoviesRepositories) {
    suspend fun execute():List<Movie>? = moviesRepositories.updateMovies()
}