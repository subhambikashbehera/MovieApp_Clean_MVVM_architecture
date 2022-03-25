package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.GetArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.UpdateArtistUseCases

class ArtistActivityViewModel(
    private val getArtistUseCases: GetArtistUseCases,
    private val updateArtistUseCases: UpdateArtistUseCases
) : ViewModel() {

    fun getArtistUseCases(): LiveData<List<Artist>?> = liveData {
        val response = getArtistUseCases.execute()
        emit(response)
    }

    fun updateArtistUseCases(): LiveData<List<Artist>?> = liveData {
        val response = updateArtistUseCases.execute()
        emit(response)
    }

}