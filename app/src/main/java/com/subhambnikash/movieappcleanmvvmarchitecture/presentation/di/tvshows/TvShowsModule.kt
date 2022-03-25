package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.tvshows

import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.GetTvShowUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.UpdateTvShowUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.presentation.tvshow.TvShowActivityViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class TvShowsModule {

    @TvShowsScope
    @Provides
    fun provideTvShowsViewModelFactory(getTvShowUseCases: GetTvShowUseCases,updateTvShowUseCases: UpdateTvShowUseCases):TvShowActivityViewModelFactory{
        return TvShowActivityViewModelFactory(getTvShowUseCases, updateTvShowUseCases)
    }
}