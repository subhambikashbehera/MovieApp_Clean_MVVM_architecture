package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCache():List<Movie>
    suspend fun updateMovieToCache(movieList:List<Movie>)
}