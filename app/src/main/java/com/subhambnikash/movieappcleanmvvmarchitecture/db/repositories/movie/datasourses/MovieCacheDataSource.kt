package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.movie.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun updateMovieToCache(movieList:List<Movie>)
}