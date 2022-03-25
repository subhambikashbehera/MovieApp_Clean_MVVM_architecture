package com.subhambnikash.movieappcleanmvvmarchitecture.data.online

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.ArtistList
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.MovieList
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apikey: String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apikey: String): Response<ArtistList>

}