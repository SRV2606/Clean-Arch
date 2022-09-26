package com.example.data.mappers

import ResponseClosedPrs
import com.example.data.serverModels.ResponseUser
import com.example.domain.ClientResult
import com.example.domain.models.ClosedPullRequests
import com.example.domain.models.User

class ClosedPRMapper {

    fun toPRList(responseClosedPrs: ClientResult<List<ResponseClosedPrs>>): ClientResult<List<ClosedPullRequests>> {
        return responseClosedPrs.let { clientRes ->
            when (clientRes) {
                is ClientResult.Success -> {
                    val result = clientRes.data.map {
                        ClosedPullRequests(
                            title = it.title,
                            createdAt = it.createdAt,
                            user = transformUser(it.user)
                        )
                    }
                    return ClientResult.Success(result)
                }
                is ClientResult.Error -> {
                    return ClientResult.Error(clientRes.error)

                }
                else -> {
                    ClientResult.InProgress
                }
            }
        }
    }

    private fun transformUser(respUser: ResponseUser?): User? {
        respUser?.let {
            return User(
                id = it.id,
                login = it.login,
                nodeId = it.nodeId,
                organizationsUrl = it.organizationsUrl
            )
        }
        return null
    }
}