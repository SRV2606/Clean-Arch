package com.example.showclosedpr.com.example.showclosedpr.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ClientResult
import com.example.domain.models.ClosedPullRequests
import com.example.domain.usecase.GetClosedPrsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PullReqViewModel @Inject constructor(private val userCase: GetClosedPrsUseCase) :
    ViewModel() {

    private val _closedPrsList: MutableStateFlow<ClientResult<List<ClosedPullRequests>>> =
        MutableStateFlow(ClientResult.InProgress)
    val closePrsList = _closedPrsList.asStateFlow()


    init {
        getClosedPrsList()
    }

    fun getClosedPrsList() {
        viewModelScope.launch {
            _closedPrsList.emit(ClientResult.InProgress)
            when (val result = userCase.getClosedPRsList()) {
                is ClientResult.Success -> {
                    _closedPrsList.emit(result)
                }
                is ClientResult.Error -> {
                    Log.d("SHAW_TAG", "getClosedPrsList: " + result.error)
                }

                else -> {}
            }
        }
    }
}