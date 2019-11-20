package com.don.coinema

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Created by don on 2019-11-19
 */
data class Movie(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overView: String,
    val adult: Boolean,
    @field:Json(name = "poster_path") val posterPath: String
)

data class MovieResponse(
    public val results: List<Movie>
)