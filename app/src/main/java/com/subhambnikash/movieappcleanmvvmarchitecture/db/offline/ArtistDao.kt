package com.subhambnikash.movieappcleanmvvmarchitecture.db.offline

import androidx.lifecycle.LiveData
import androidx.room.*
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artistList:List<Artist>)

    @Query("DELETE FROM artist_table")
    fun deleteArtist():Int

    @Query("SELECT * FROM artist_table")
     fun getArtist():List<Artist>



}