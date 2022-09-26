package com.example.domain.usecase

import com.example.domain.ClientResult
import com.example.domain.models.ClosedPullRequests
import com.example.domain.repositories.PullReqRepository
import javax.inject.Inject

class GetClosedPrsUseCase @Inject constructor(private val repository: PullReqRepository) {

    suspend fun getClosedPRsList(): ClientResult<List<ClosedPullRequests>> {
        return repository.getClosedPrsList()
    }


}