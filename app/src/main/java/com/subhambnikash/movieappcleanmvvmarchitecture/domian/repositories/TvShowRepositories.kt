package com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow

interface TvShowRepositories {

    suspend fun getTvShow():List<TvShow>?
    suspend fun updateTvShows():List<TvShow>?

}