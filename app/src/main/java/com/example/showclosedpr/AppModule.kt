package com.example.showclosedpr

import com.example.data.mappers.ClosedPRMapper
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
    fun provideClosedPrMapper(): ClosedPRMapper {
        return ClosedPRMapper()
    }
}