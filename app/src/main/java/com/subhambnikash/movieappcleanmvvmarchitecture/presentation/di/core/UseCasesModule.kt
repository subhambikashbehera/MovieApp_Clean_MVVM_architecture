package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.ArtistRepositories
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.MoviesRepositories
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.TvShowRepositories
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.GetArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.artist.UpdateArtistUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.GetMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.movie.UpdateMoviesUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.GetTvShowUseCases
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows.UpdateTvShowUseCases
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UseCasesModule {


    @Singleton
    @Provides
    fun provideUpdateMovieUseCases(moviesRepositories: MoviesRepositories):UpdateMoviesUseCases{
        return UpdateMoviesUseCases(moviesRepositories)
    }

    @Singleton
    @Provides
    fun provideGetMovieUseCases(moviesRepositories: MoviesRepositories):GetMoviesUseCases{
        return GetMoviesUseCases(moviesRepositories)
    }



    @Singleton
    @Provides
    fun provideUpdateArtistUseCases(artistRepositories: ArtistRepositories):UpdateArtistUseCases{
        return UpdateArtistUseCases(artistRepositories)
    }

    @Singleton
    @Provides
    fun provideGetArtistUseCases(artistRepositories: ArtistRepositories):GetArtistUseCases{
        return GetArtistUseCases(artistRepositories)
    }




    @Singleton
    @Provides
    fun provideUpdateTvShowsUseCases(tvShowRepositories: TvShowRepositories):UpdateTvShowUseCases{
        return UpdateTvShowUseCases(tvShowRepositories)
    }

    @Singleton
    @Provides
    fun provideGetTvShowsUseCases(tvShowRepositories: TvShowRepositories):GetTvShowUseCases{
        return GetTvShowUseCases(tvShowRepositories)
    }


}