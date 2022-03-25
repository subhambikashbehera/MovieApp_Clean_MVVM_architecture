package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.GetMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.UpdateMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow.TvShowActivityViewModel
import java.lang.IllegalArgumentException

class MovieActivityViewModelFactory(
    private val getMoviesUseCases: GetMoviesUseCases,
    private val updateMoviesUseCases: UpdateMoviesUseCases
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieActivityViewModel(
            getMoviesUseCases,
            updateMoviesUseCases
        ) as T
    }
}