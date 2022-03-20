package com.subhambnikash.movieappcleanmvvmarchitecture.db.offline

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow


@Database(entities = [Artist::class,Movie::class,TvShow::class], exportSchema = true, version = 1)
abstract class GetDataBaseInstance:RoomDatabase() {

    abstract val tvShowsDao:TvShowsDao
    abstract val moviesDao:MoviesDao
    abstract val artistsDao:ArtistDao

    companion object{
        @Volatile
        var dataBaseInstance:GetDataBaseInstance?=null
        fun getDataBaseInstances(context: Context):GetDataBaseInstance{
            synchronized(this){
                if (dataBaseInstance==null){
                    dataBaseInstance=Room.databaseBuilder(context.applicationContext,GetDataBaseInstance::class.java,"tmtbDb").fallbackToDestructiveMigration().build()
                }
            }
            return dataBaseInstance!!
        }
    }


}