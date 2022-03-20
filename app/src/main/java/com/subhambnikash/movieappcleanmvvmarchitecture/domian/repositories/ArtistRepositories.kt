package com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

interface ArtistRepositories {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}