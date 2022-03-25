package com.subhambnikash.movieappcleanmvvmarchitecture.data.offline

import androidx.room.*
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artistList:List<Artist>)

    @Query("DELETE FROM artist_table")
    suspend fun deleteArtist():Int

    @Query("SELECT * FROM artist_table")
     suspend fun getArtist():List<Artist>



}