package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist

interface ArtistLocalDataSources {
    suspend fun getArtistFromDb():List<Artist>
    suspend fun clearAllArtistFromDb()
    suspend fun updateArtistToDb(listArtist:List<Artist>)
}