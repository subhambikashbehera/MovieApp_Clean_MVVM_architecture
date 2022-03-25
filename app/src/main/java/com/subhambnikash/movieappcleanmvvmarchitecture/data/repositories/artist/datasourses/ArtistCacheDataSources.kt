package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.artist.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.artist.Artist

interface ArtistCacheDataSources {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun updateArtistToCache(artistList:List<Artist>)
}