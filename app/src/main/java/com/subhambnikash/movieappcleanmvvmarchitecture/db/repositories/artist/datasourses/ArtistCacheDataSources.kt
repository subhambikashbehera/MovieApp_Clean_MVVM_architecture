package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.artist.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist.Artist
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

interface ArtistCacheDataSources {
    suspend fun getArtistFromCache():List<Artist>
    suspend fun updateArtistToCache(artistList:List<Artist>)
}