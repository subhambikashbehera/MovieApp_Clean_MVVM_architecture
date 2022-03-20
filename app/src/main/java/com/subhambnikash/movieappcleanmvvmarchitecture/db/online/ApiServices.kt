package com.subhambnikash.movieappcleanmvvmarchitecture.db.online

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.ArtistList
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.MovieList
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apikey:String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("api_key") apikey:String): Response<TvShowList>

    @GET("person/popular")
    suspend fun getPopularArtists(@Query("api_key") apikey:String): Response<ArtistList>
}