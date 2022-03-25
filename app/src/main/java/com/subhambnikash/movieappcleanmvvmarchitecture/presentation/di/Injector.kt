package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di

import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.artist.ArtistSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.movie.MovieSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.tvshows.TvShowSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvShowsSubComponent():TvShowSubComponent
}