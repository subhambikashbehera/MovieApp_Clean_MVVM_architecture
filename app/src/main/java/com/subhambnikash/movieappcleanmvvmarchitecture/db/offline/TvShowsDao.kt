package com.subhambnikash.movieappcleanmvvmarchitecture.db.offline

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow

@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShowList:List<TvShow>)

    @Query("DELETE FROM tv_show_table")
    fun deleteTvShows():Int

    @Query("SELECT * FROM tv_show_table")
    fun getTvShows(): List<TvShow>
}