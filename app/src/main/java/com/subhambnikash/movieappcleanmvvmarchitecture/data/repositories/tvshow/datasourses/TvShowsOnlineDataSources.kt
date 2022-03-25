package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShowList
import retrofit2.Response

interface TvShowsOnlineDataSources {

    suspend fun getTvShowFromAPi():Response<TvShowList>

}