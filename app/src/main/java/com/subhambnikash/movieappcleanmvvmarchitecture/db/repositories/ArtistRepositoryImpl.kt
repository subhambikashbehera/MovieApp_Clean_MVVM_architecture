package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses.ArtistCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses.ArtistLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses.ArtistOnlineDataSources
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
       artistLocalDataSources.updateArtistToDb(newArtistNewList)
       artistCacheDataSources.updateArtistToCache(newArtistNewList)
       return newArtistNewList
    }


    private suspend fun getArtistsFromApi(): List<Artist> {
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