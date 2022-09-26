package com.example.data.remote

import ResponseClosedPrs
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {


    @GET("repos/bumptech/glide/pulls?state=closed")
    suspend fun getClosedPrsList(): Response<List<ResponseClosedPrs>>


}