package com.subhambnikash.movieappcleanmvvmarchitecture.data.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow

@Dao
interface TvShowsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShows(tvShowList:List<TvShow>)

    @Query("DELETE FROM tv_show_table")
    suspend fun deleteTvShows():Int

    @Query("SELECT * FROM tv_show_table")
    suspend fun getTvShows(): List<TvShow>
}