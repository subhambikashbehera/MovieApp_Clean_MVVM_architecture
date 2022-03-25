package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShowList
import com.subhambnikash.movieappcleanmvvmarchitecture.data.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsOnlineDataSources
import retrofit2.Response

class TvShowsOnlineDataSourcesImpl(private val apiServices: ApiServices,private val apiKey:String): TvShowsOnlineDataSources {
    override suspend fun getTvShowFromAPi(): Response<TvShowList> {
        return apiServices.getPopularTvShows(apiKey)
    }
}