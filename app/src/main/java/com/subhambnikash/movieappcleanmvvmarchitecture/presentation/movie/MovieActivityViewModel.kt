package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.GetMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.UpdateMoviesUseCases

class MovieActivityViewModel(
    private val getMoviesUseCases: GetMoviesUseCases,
    private val updateMoviesUseCases: UpdateMoviesUseCases
) : ViewModel() {

    fun getMoviesUseCases():LiveData<List<Movie>?> = liveData {
        val response=getMoviesUseCases.execute()
        emit(response)
    }


    fun updateMovieShows():LiveData<List<Movie>?> = liveData {
        val response=updateMoviesUseCases.execute()
        emit(response)
    }

}