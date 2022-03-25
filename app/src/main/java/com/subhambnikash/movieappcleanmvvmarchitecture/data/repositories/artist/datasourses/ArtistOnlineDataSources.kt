package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistOnlineDataSources {
    suspend fun getArtistsFromApi(): Response<ArtistList>
}