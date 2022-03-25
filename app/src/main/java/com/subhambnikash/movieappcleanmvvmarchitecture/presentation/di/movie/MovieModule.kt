package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.movie

import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.GetArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.UpdateArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.GetMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.UpdateMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist.ArtistActivityViewModelFactory
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie.MovieActivityViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
    getMoviesUseCases: GetMoviesUseCases,
    updateMoviesUseCases: UpdateMoviesUseCases
    ):MovieActivityViewModelFactory {
        return MovieActivityViewModelFactory(getMoviesUseCases, updateMoviesUseCases)
    }
}