package com.don.coinema

/**
 * Created by don on 2019-11-19
 */
data class Movie(
    val id: Int,
    val vote_average: Double,
    val title: String,
    val overView: String,
    val adult: Boolean
)

data class MovieResponse(
    val results: List<Movie>
)