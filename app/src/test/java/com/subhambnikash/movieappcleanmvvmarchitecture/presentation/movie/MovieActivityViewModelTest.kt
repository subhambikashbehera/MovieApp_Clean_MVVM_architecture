package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie

import android.support.test.runner.AndroidJUnit4
import androidx.arch.core.executor.testing.InstantTaskExecutorRule


import com.google.common.truth.Truth
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.FakeMovieRepository
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.GetMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.UpdateMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.getOrAwaitValue

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MovieActivityViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieActivityViewModel: MovieActivityViewModel


    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUseCases = GetMoviesUseCases(fakeMovieRepository)
        val updateMoviesUseCases = UpdateMoviesUseCases(fakeMovieRepository)
        movieActivityViewModel= MovieActivityViewModel(getMoviesUseCases,updateMoviesUseCases)
    }


    @Test
    fun getMovies() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "path1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "path2", "date2", "title2"))

       val currentList= movieActivityViewModel.getMoviesUseCases().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(movies)
    }


    @Test
    fun updateMovies() {
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "path3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "path4", "date4", "title4"))

        val updatedList= movieActivityViewModel.updateMovieShows().getOrAwaitValue()
        Truth.assertThat(updatedList).isEqualTo(movies)
    }



}