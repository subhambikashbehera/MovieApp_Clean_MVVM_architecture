package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasoursesimpl.ArtistCacheDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieCacheDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl.MovieCacheDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasoursesimpl.TvShowsCacheDataSourcesImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataSourcesModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourcesImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSources{
        return ArtistCacheDataSourcesImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowsCacheDataSource():TvShowsCacheDataSources{
        return TvShowsCacheDataSourcesImpl()
    }
}