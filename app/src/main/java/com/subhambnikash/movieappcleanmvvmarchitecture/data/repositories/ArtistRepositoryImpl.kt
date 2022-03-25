package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories

import android.util.Log
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.ArtistRepositories

class ArtistRepositoryImpl(
    private val artistOnlineDataSources: ArtistOnlineDataSources,
    private val artistLocalDataSources: ArtistLocalDataSources,
    private val artistCacheDataSources: ArtistCacheDataSources
) : ArtistRepositories {
    override suspend fun getArtists(): List<Artist>? {
       return getArtistsFromCache()
    }

    override suspend fun updateArtist(): List<Artist>? {
       artistLocalDataSources.clearAllArtistFromDb()
       val newArtistNewList=getArtistsFromApi()
        Log.d("checkData", "getArtistsFromCache: $newArtistNewList")

       artistLocalDataSources.updateArtistToDb(newArtistNewList)
       artistCacheDataSources.updateArtistToCache(newArtistNewList)
       return newArtistNewList
    }


    private suspend fun getArtistsFromApi(): List<Artist> {
        Log.d("checkData", "getArtistsFromCache: api")
        lateinit var artistList: List<Artist>
        try {
            val response = artistOnlineDataSources.getArtistsFromApi()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return artistList
    }


    private suspend fun getArtistsFromLocalDb(): List<Artist> {
        Log.d("checkData", "getArtistsFromCache: db")
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSources.getArtistFromDb()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromApi()
            artistLocalDataSources.updateArtistToDb(artistList)
        }

        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {

        Log.d("checkData", "getArtistsFromCache: cache")

        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSources.getArtistFromCache()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistsFromLocalDb()
            artistCacheDataSources.updateArtistToCache(artistList)
        }

        return artistList

    }
}