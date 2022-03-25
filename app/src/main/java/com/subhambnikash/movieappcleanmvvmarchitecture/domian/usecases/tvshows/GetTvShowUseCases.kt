package com.subhambnikash.movieappcleanmvvmarchitecture.domian.usecases.tvshows

import com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows.TvShow
import com.subhambnikash.movieappcleanmvvmarchitecture.domian.repositories.TvShowRepositories

class GetTvShowUseCases(private val tvShowRepositories: TvShowRepositories) {

    suspend fun execute():List<TvShow>? = tvShowRepositories.getTvShow()
}