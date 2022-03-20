package com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies

import com.google.gson.annotations.SerializedName
import com.subhambnikash.movieappcleanmvvmarchitecture.db.model.movies.Movie

data class MovieList(
    @SerializedName("result")
    val movies: ArrayList<Movie>
)