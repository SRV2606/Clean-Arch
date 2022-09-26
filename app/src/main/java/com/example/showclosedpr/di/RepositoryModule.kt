package com.example.showclosedpr.di

import com.example.data.repoImpl.PullReqRepositoryImpl
import com.example.domain.repositories.PullReqRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPullReqRepository(
        pullReqRepositoryImpl: PullReqRepositoryImpl
    ): PullReqRepository


}