package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.GetTvShowUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.UpdateTvShowUseCases

class TvShowActivityViewModel(
    private val getTvShowUseCases: GetTvShowUseCases,
    private val updateTvShowUseCases: UpdateTvShowUseCases
) : ViewModel() {

    fun getTvShoesUseCases(): LiveData<List<TvShow>?> = liveData {
        val responses = getTvShowUseCases.execute()
        emit(responses)
    }

    fun updateTvShowsUseCases(): LiveData<List<TvShow>?> = liveData {
        val responses = updateTvShowUseCases.execute()
        emit(responses)
    }

}