package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.MovieList
import retrofit2.Response

interface MovieOnlineDataSource {
   suspend fun getMoviesFromApi():Response<MovieList>
}