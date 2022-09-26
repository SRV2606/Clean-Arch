package com.example.showclosedpr.di

import com.example.data.remote.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    private val BASE_URL = "https://api.github.com/"

    @Provides
    fun provideService(@com.example.data.Utils.utils.Retrofit retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @com.example.data.Utils.utils.Retrofit
    fun retrofit(
        @com.example.data.Utils.utils.OkHttpClient okHttpClient: OkHttpClient,
        @com.example.data.Utils.utils.Gson gson: Gson
    ): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .build()
    }

    @Provides
    @com.example.data.Utils.utils.Gson
    fun gson(): Gson {
        return GsonBuilder().create()
    }

}