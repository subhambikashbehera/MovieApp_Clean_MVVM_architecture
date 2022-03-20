package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses.ArtistCacheDataSources

class ArtistCacheDataSourcesImpl: ArtistCacheDataSources {

    var artistListNew=ArrayList<Artist>()
    override suspend fun getArtistFromCache(): List<Artist> {
        return artistListNew
    }

    override suspend fun updateArtistToCache(artistList: List<Artist>) {
        artistListNew.clear()
        artistListNew = ArrayList(artistList)
    }
}