package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.db.offline.TvShowsDao
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses.TvShowsLocalDataSources

class TvShowsLocalDataSourcesImpl(private val tvShowsDao: TvShowsDao): TvShowsLocalDataSources {
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }
    override suspend fun clearAllTvShows() {
        tvShowsDao.deleteTvShows()
    }
    override suspend fun updateTvShows(tvShows: List<TvShow>) {
      tvShowsDao.saveTvShows(tvShows)
    }
}