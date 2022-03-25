package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.tvshows

import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow.TvShowActivity
import dagger.Subcomponent


@TvShowsScope
@Subcomponent(modules = [TvShowsModule::class])
interface TvShowSubComponent {
    fun inject(tvShowActivity: TvShowActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }
}