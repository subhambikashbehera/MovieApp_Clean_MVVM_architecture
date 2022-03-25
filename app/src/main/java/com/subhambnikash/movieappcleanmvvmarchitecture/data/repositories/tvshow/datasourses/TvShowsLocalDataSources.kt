package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow

interface TvShowsLocalDataSources {
    suspend fun getTvShowsFromDb():List<TvShow>
    suspend fun clearAllTvShows()
    suspend fun updateTvShows(tvShows:List<TvShow>)
}