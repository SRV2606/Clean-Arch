package com.example.data.repoImpl

import com.example.data.Utils.utils.safeApiCall
import com.example.data.mappers.ClosedPRMapper
import com.example.data.remote.ApiService
import com.example.domain.ClientResult
import com.example.domain.models.ClosedPullRequests
import com.example.domain.repositories.PullReqRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PullReqRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val closedPRMapper: ClosedPRMapper
) : PullReqRepository {

    override suspend fun getClosedPrsList(): ClientResult<List<ClosedPullRequests>> {
        return withContext(Dispatchers.IO) {
            return@withContext closedPRMapper.toPRList(safeApiCall { apiService.getClosedPrsList() })
        }
    }
}