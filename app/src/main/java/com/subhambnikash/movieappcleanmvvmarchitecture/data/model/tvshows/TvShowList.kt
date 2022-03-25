package com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows

import com.google.gson.annotations.SerializedName

data class TvShowList(

    @SerializedName("results")
    val tvShows: ArrayList<TvShow>,

    )