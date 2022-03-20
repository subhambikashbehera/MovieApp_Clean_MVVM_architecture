package com.subhambnikash.movieappcleanmvvmarchitecture.db.model.artist

import com.google.gson.annotations.SerializedName

data class ArtistList(
    @SerializedName("result")
    val artists: List<Artist>
)