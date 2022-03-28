package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.GetTvShowUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.UpdateTvShowUseCases
import java.lang.IllegalArgumentException

class TvShowActivityViewModelFactory(
    private val getTvShowUseCases: GetTvShowUseCases,
    private val updateTvShowUseCases: UpdateTvShowUseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
           return TvShowActivityViewModel(getTvShowUseCases,updateTvShowUseCases) as T
    }
}