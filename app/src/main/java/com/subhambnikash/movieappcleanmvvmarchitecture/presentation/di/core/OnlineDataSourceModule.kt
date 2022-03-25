package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import com.subhambnikash.movieappcleanmvvmarchitecture.data.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasoursesimpl.ArtistOnlineDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieOnlineDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl.MovieLocalDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl.MovieOnlineDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasoursesimpl.TvShowsOnlineDataSourcesImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class OnlineDataSourceModule(private val apiKey:String){

    @Singleton
    @Provides
    fun provideMovieOnlineDataSource(apiServices: ApiServices):MovieOnlineDataSource{
        return MovieOnlineDataSourcesImpl(apiServices,apiKey)
    }


    @Singleton
    @Provides
    fun provideTvShowsOnlineDataSource(apiServices: ApiServices):TvShowsOnlineDataSources{
        return TvShowsOnlineDataSourcesImpl(apiServices,apiKey)
    }


    @Singleton
    @Provides
    fun provideArtistOnlineDataSource(apiServices: ApiServices):ArtistOnlineDataSources{
        return ArtistOnlineDataSourcesImpl(apiServices,apiKey)
    }

}