package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.ArtistDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.MoviesDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.TvShowsDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasoursesimpl.ArtistLocalDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasoursesimpl.ArtistOnlineDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieLocalDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieOnlineDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl.MovieLocalDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasoursesimpl.MovieOnlineDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasoursesimpl.TvShowsLocalDataSourcesImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasoursesimpl.TvShowsOnlineDataSourcesImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataSourcesModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(moviesDao: MoviesDao): MovieLocalDataSource {
        return MovieLocalDataSourcesImpl(moviesDao)
    }


    @Singleton
    @Provides
    fun provideTvShowsLocalDataSource(tvShowsDao: TvShowsDao): TvShowsLocalDataSources {
        return TvShowsLocalDataSourcesImpl(tvShowsDao)
    }


    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSources {
        return ArtistLocalDataSourcesImpl(artistDao)
    }
}