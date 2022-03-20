package com.subhambnikash.movieappcleanmvvmarchitecture.db.offline

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movieList:List<Movie>)

    @Query("DELETE FROM movie_table")
   suspend fun deleteMovie():Int

    @Query("SELECT * FROM movie_table")
   suspend fun getMovie():List<Movie>
}