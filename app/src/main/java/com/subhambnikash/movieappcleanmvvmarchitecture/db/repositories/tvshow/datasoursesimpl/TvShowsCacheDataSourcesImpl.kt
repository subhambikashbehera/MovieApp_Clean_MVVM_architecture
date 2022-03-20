package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses.TvShowsCacheDataSources

class TvShowsCacheDataSourcesImpl: TvShowsCacheDataSources {
    var tvShowListNew = ArrayList<TvShow>()
    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowListNew
    }

    override suspend fun updateTvShowsToCache(tvShowList: List<TvShow>) {
        tvShowListNew.clear()
        tvShowListNew = ArrayList(tvShowList)
    }
}