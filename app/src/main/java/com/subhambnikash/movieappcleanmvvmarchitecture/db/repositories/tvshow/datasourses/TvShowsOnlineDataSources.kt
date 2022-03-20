package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShowList
import retrofit2.Response

interface TvShowsOnlineDataSources {

    suspend fun getTvShowFromAPi():Response<TvShowList>

}