package com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasoursesimpl

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.data.offline.TvShowsDao
import com.subhambnikash.movieappcleanmvvmarchitecture.data.repositories.tvshow.datasourses.TvShowsLocalDataSources
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowsLocalDataSourcesImpl(private val tvShowsDao: TvShowsDao): TvShowsLocalDataSources {
    override suspend fun getTvShowsFromDb(): List<TvShow> {
        return tvShowsDao.getTvShows()
    }
    override suspend fun clearAllTvShows() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.deleteTvShows()
        }

    }
    override suspend fun updateTvShows(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowsDao.saveTvShows(tvShows)
        }
    }
}