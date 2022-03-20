package com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows

import com.google.gson.annotations.SerializedName
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.tvshows.TvShow

data class TvShowList(

    @SerializedName("result")
    val tvShows: ArrayList<TvShow>,

    )