package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.movie.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.MovieList
import retrofit2.Response

interface MovieOnlineDataSource {
   suspend fun getMoviesFromApi():Response<MovieList>
}