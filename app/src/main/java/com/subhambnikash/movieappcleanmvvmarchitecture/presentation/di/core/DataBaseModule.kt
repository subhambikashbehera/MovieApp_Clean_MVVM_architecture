package com.subhambnikash.movieappcleanmvvmarchitecture.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.ArtistDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.GetDataBaseInstance
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.MoviesDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.TvShowsDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class DataBaseModule {


    @Singleton
    @Provides
    fun provideDataBase(context: Context): GetDataBaseInstance {
      return synchronized(this) {
            Room.databaseBuilder(
                context.applicationContext,
                GetDataBaseInstance::class.java,
                "tmtbDb"
            ).fallbackToDestructiveMigration().build() }}


    @Singleton
    @Provides
    fun provideMovieDao(dataBaseInstance: GetDataBaseInstance):MoviesDao{
        return dataBaseInstance.moviesDao()
    }

    @Singleton
    @Provides
    fun provideArtistDao(dataBaseInstance: GetDataBaseInstance):ArtistDao{
        return dataBaseInstance.artistsDao()
    }

    @Singleton
    @Provides
    fun provideTvShowsDao(dataBaseInstance: GetDataBaseInstance):TvShowsDao{
        return dataBaseInstance.tvShowsDao()
    }



}