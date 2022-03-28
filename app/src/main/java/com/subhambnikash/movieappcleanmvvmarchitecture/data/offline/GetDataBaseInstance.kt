package com.subhambnikash.movieappcleanmvvmarchitecture.data.offline

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow


@Database(entities = [Artist::class,Movie::class,TvShow::class], exportSchema = false, version = 1)
abstract class GetDataBaseInstance:RoomDatabase() {
    abstract fun tvShowsDao(): TvShowsDao
    abstract fun moviesDao(): MoviesDao
    abstract fun artistsDao(): ArtistDao

}