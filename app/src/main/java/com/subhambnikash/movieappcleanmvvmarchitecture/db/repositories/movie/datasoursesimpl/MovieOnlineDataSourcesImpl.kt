package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.movie.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.MovieList
import com.subhambnikash.movieappcleanmvvmarchitecture.db.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.movie.datasourses.MovieOnlineDataSource
import retrofit2.Response

class MovieOnlineDataSourcesImpl(private val apiServices: ApiServices, private val apiKey:String):MovieOnlineDataSource {
    override suspend fun getMoviesFromApi(): Response<MovieList> = apiServices.getPopularMovies(apiKey)
}