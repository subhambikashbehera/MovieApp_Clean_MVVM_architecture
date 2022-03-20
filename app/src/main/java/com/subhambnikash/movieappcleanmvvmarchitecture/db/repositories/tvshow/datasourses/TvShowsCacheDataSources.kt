package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShowList

interface TvShowsCacheDataSources {
    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun updateTvShowsToCache(tvShowList:List<TvShow>)
}