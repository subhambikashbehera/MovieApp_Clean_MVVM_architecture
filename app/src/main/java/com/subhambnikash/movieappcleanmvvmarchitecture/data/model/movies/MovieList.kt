package com.subhambnikash.movieappcleanmvvmarchitecture.data.model.movies

import com.google.gson.annotations.SerializedName

data class MovieList(
    @SerializedName("results")
    val movies: List<Movie>
)