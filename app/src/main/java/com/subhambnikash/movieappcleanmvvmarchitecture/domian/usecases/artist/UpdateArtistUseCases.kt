package com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.ArtistRepositories

class UpdateArtistUseCases(private val artistRepository: ArtistRepositories) {
    suspend fun execute():List<Artist>? = artistRepository.updateArtist()
}