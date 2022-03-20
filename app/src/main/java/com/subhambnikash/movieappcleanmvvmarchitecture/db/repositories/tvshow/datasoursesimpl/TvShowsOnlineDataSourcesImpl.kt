package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShowList
import com.subhambnikash.movieappcleanmvvmarchitecture.db.online.ApiServices
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses.TvShowsOnlineDataSources
import retrofit2.Response

class TvShowsOnlineDataSourcesImpl(private val apiServices: ApiServices,private val apiKey:String): TvShowsOnlineDataSources {
    override suspend fun getTvShowFromAPi(): Response<TvShowList> {
        return apiServices.getPopularTvShows(apiKey)
    }
}