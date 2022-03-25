package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow

interface TvShowsCacheDataSources {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun updateTvShowsToCache(tvShowList:List<TvShow>)
}