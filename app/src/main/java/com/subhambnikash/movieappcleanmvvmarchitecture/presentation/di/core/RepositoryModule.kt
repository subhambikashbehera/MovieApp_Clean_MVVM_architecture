package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.ArtistRepositoryImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.MovieRepositoryImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.TvShowRepositoryImpl
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieCacheDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieLocalDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.movie.datasourses.MovieOnlineDataSource
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.ArtistRepositories
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.MoviesRepositories
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.TvShowRepositories
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {


    @Singleton
    @Provides
    fun provideMovieRepository(
        movieOnlineDataSource: MovieOnlineDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MoviesRepositories {
        return MovieRepositoryImpl(
            movieOnlineDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideArtistRepository(
        artistOnlineDataSources: ArtistOnlineDataSources,
        artistLocalDataSources: ArtistLocalDataSources,
        artistCacheDataSources: ArtistCacheDataSources
    ): ArtistRepositories {
        return ArtistRepositoryImpl(
            artistOnlineDataSources,
            artistLocalDataSources,
            artistCacheDataSources
        )
    }


    @Singleton
    @Provides
    fun provideTvShowsRepository(
        tvShowsOnlineDataSources: TvShowsOnlineDataSources,
        tvShowsLocalDataSources: TvShowsLocalDataSources,
        tvShowsCacheDataSources: TvShowsCacheDataSources
    ): TvShowRepositories {
        return TvShowRepositoryImpl(
            tvShowsOnlineDataSources,
            tvShowsLocalDataSources,
            tvShowsCacheDataSources
        )
    }


}