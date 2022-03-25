package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.ArtistList
import com.subhambnikash.movieappcleanmvvmarchitecture.data.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistOnlineDataSources
import retrofit2.Response

class ArtistOnlineDataSourcesImpl(private val apiServices: ApiServices,private val apiKey:String): ArtistOnlineDataSources {
    override suspend fun getArtistsFromApi(): Response<ArtistList> {
       return apiServices.getPopularArtists(apiKey)
    }
}