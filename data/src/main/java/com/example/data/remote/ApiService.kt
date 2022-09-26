package com.example.data.remote

import ResponseClosedPrs
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("repos/bumptech/glide/pulls?state=closed")
    suspend fun getClosedPrsList(@Query("state") state: String): Response<List<ResponseClosedPrs>>


}