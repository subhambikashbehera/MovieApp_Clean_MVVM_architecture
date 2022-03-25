package com.subhambnikash.movieappcleanmvvmarchitecture.data.model.tvshows

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "tv_show_table")
data class TvShow(
    @SerializedName("firstAirDate")
    val firstAirDate:String?,
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val poster_path: String?,
)