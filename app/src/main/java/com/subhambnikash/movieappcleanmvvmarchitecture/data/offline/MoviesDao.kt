package com.subhambnikash.movieappcleanmvvmarchitecture.data.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies.Movie

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movieList:List<Movie>)

    @Query("DELETE FROM movie_table")
   suspend fun deleteMovie():Int

    @Query("SELECT * FROM movie_table")
   suspend fun getMovie():List<Movie>
}