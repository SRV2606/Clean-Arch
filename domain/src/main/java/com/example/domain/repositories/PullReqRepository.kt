package com.example.domain.repositories

import com.example.domain.ClientResult
import com.example.domain.models.ClosedPullRequests

interface PullReqRepository {
    suspend fun getClosedPrsList(): ClientResult<List<ClosedPullRequests>>

}