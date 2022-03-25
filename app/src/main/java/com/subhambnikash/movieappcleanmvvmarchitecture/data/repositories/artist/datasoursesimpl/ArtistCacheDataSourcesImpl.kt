package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasoursesimpl

import android.util.Log
import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses.ArtistCacheDataSources

class ArtistCacheDataSourcesImpl: ArtistCacheDataSources {

    var artistListNew=ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        Log.d("checkData", "updateArtistToCachevvvxx: $artistListNew")
        return artistListNew
    }

    override suspend fun updateArtistToCache(artistList: List<Artist>) {
        Log.d("checkData", "updateArtistToCachevvv: $artistList")
        artistListNew.clear()
        artistListNew = ArrayList(artistList)
    }
}