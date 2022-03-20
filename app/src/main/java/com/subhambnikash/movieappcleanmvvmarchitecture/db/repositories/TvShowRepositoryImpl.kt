package com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses.TvShowsCacheDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses.TvShowsLocalDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.db.repositories.tvshow.datasourses.TvShowsOnlineDataSources
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.TvShowRepositories
import java.lang.Exception

class TvShowRepositoryImpl(
    private val tvShowsOnlineDataSources: TvShowsOnlineDataSources,
    private var tvShowsLocalDataSources: TvShowsLocalDataSources,
    private val tvShowsCacheDataSources: TvShowsCacheDataSources
) : TvShowRepositories {
    override suspend fun getTvShow(): List<TvShow>? {
      return getTvShowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        tvShowsLocalDataSources.clearAllTvShows()
        val newTvShowList=getTvShowsFromApi()
        tvShowsLocalDataSources.updateTvShows(newTvShowList)
        tvShowsCacheDataSources.updateTvShowsToCache(newTvShowList)
        return newTvShowList
    }


    private suspend fun getTvShowsFromApi():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
           val response=tvShowsOnlineDataSources.getTvShowFromAPi()
            val body=response.body()
            if (body!=null){
                tvShowList=body.tvShows
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
        return tvShowList
    }

    private   suspend fun getTvShowsFromLocalDb():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
             tvShowList=tvShowsLocalDataSources.getTvShowsFromDb()
        }catch (e:Exception){
            e.printStackTrace()
        }

        if (tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList=getTvShowsFromApi()
            tvShowsLocalDataSources.updateTvShows(tvShowList)
        }

        return tvShowList
    }

   private suspend fun getTvShowsFromCache():List<TvShow> {
        lateinit var tvShowList:List<TvShow>
        try {
            tvShowList=tvShowsCacheDataSources.getTvShowsFromCache()
        }catch (e:Exception){
            e.printStackTrace()
        }

        if (tvShowList.isNotEmpty()){
            return tvShowList
        }else{
            tvShowList=getTvShowsFromLocalDb()
            tvShowsCacheDataSources.updateTvShowsToCache(tvShowList)
        }

        return tvShowList

    }
}