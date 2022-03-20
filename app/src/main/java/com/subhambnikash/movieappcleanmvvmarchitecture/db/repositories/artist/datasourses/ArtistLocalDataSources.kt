package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

interface ArtistLocalDataSources {
    suspend fun getArtistFromDb():List<Artist>
    suspend fun clearAllArtistFromDb()
    suspend fun updateArtistToDb(listArtist:List<Artist>)
}