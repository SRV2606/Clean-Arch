package com.example.showclosedpr.di

import com.example.data.mappers.PullReqMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    @Singleton
    fun provideClosedPrMapper(): PullReqMapper {
        return PullReqMapper()
    }
}