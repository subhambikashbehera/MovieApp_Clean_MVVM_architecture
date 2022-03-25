package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.MovieList
import com.subhambnikash.movieappcleanmvvmarchitecture.data.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieOnlineDataSource
import retrofit2.Response

class MovieOnlineDataSourcesImpl(private val apiServices: ApiServices, private val apiKey: String) :
    MovieOnlineDataSource {
    override suspend fun getMoviesFromApi(): Response<MovieList> = apiServices.getPopularMovies(apiKey)
}