package com.don.coinema

import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by don on 2019-11-19
 */
interface MovieApi {

    @GET("movie/popular")
    fun getPopularMovie(): Call<MovieResponse>
}