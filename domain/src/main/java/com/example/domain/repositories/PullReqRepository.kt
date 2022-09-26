package com.example.domain.repositories

import com.example.domain.ClientResult
import com.example.domain.models.ClosedPrs

interface PullReqRepository {
    suspend fun getClosedPrsList(state: String): ClientResult<List<ClosedPrs>>

}