package com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist

interface ArtistRepositories {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtist(): List<Artist>?
}