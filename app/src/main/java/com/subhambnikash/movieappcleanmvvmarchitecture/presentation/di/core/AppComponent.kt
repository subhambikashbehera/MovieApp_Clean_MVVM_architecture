package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.artist.ArtistSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.movie.MovieSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.tvshows.TvShowSubComponent
import dagger.Component
import dagger.Module
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        DataBaseModule::class,
        UseCasesModule::class,
        RepositoryModule::class,
        OnlineDataSourceModule::class,
        LocalDataSourcesModule::class,
        CacheDataSourcesModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
    fun tvShowsSubComponent(): TvShowSubComponent.Factory

}