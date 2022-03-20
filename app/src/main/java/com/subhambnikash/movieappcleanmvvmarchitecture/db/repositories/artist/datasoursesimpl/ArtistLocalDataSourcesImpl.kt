package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.offline.ArtistDao
import com.subhambnikash.movieappcleanmvvmarchitecture.db.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses.ArtistLocalDataSources
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourcesImpl(private val artistDao: ArtistDao) : ArtistLocalDataSources {
    override suspend fun getArtistFromDb(): List<Artist> {
        return artistDao.getArtist()
    }

    override suspend fun clearAllArtistFromDb() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteArtist()
        }
    }

    override suspend fun updateArtistToDb(listArtist: List<Artist>) {

        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(listArtist)
        }
    }
}