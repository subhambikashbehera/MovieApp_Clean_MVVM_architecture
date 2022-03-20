package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.ArtistList
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.MovieList
import retrofit2.Response

interface ArtistOnlineDataSources {
    suspend fun getArtistsFromApi(): Response<ArtistList>
}