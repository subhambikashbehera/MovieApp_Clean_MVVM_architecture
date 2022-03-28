package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.GetArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.UpdateArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie.MovieActivityViewModelFactory
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow.TvShowActivityViewModel
import java.lang.IllegalArgumentException


class ArtistActivityViewModelFactory(
    private val getArtistUseCases: GetArtistUseCases,
    private val updateArtistUseCases: UpdateArtistUseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            ArtistActivityViewModel::class.java ->{ ArtistActivityViewModel(getArtistUseCases,updateArtistUseCases)}
            else -> {throw  IllegalArgumentException("error")}
        } as T
    }
}