package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow

interface TvShowsLocalDataSources {
    suspend fun getTvShowsFromDb():List<TvShow>
    suspend fun clearAllTvShows()
    suspend fun updateTvShows(tvShows:List<TvShow>)
}