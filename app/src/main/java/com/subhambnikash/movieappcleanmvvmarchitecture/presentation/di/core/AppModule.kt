package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import android.content.Context
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.artist.ArtistSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.movie.MovieSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.tvshows.TvShowSubComponent
import dagger.Module
import dagger.Provides


@Module(subcomponents = [MovieSubComponent::class,TvShowSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context.applicationContext
    }
}