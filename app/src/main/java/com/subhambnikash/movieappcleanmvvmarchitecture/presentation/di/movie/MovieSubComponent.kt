package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.movie

import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.artist.ArtistActivity
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.movie.MovieActivity
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {

    fun inject(movieActivity: MovieActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}