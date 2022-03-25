package com.subhambnikash.movieappcleanmvvmarchitecture.presentation

import android.app.Application
import com.subhambnikash.movieappcleanmvvmarchitecture.BuildConfig
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.Injector
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.artist.ArtistSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core.*
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.movie.MovieSubComponent
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.tvshows.TvShowSubComponent

class App : Application(), Injector {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent =
            DaggerAppComponent.builder()
                .appModule(AppModule(applicationContext))
                .netModule(NetModule(BuildConfig.BASE_URL_IMDB))
                .onlineDataSourceModule(OnlineDataSourceModule(BuildConfig.API_KEY))
                .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }



    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }



    override fun createTvShowsSubComponent(): TvShowSubComponent {
        return appComponent.tvShowsSubComponent().create()
    }
}