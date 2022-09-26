package com.example.data.repoImpl

import com.example.data.Utils.utils.safeApiCall
import com.example.data.mappers.PullReqMapper
import com.example.data.remote.ApiService
import com.example.domain.ClientResult
import com.example.domain.models.ClosedPrs
import com.example.domain.repositories.PullReqRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PullReqRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val closedPRMapper: PullReqMapper
) : PullReqRepository {

    override suspend fun getClosedPrsList(state: String): ClientResult<List<ClosedPrs>> {
        return withContext(Dispatchers.IO) {
            return@withContext closedPRMapper.toPRList(safeApiCall {
                apiService.getClosedPrsList(
                    state
                )
            })
        }
    }
}