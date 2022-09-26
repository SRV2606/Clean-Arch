package com.example.showclosedpr.com.example.showclosedpr.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.ClientResult
import com.example.domain.models.ClosedPrs
import com.example.domain.usecase.GetClosedPrsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PullReqViewModel @Inject constructor(private val userCase: GetClosedPrsUseCase) :
    ViewModel() {

    private val _closedPrsList: MutableStateFlow<ClientResult<List<ClosedPrs>>> =
        MutableStateFlow(ClientResult.InProgress)
    val closePrsList = _closedPrsList.asStateFlow()

    private val _isLoadingMLD: MutableLiveData<Boolean> = MutableLiveData(true)
    val isLoadingMLD = _isLoadingMLD


    init {
        getClosedPrsList()
    }

    fun getClosedPrsList() {
        viewModelScope.launch {
            _closedPrsList.emit(ClientResult.InProgress)
            when (val result = userCase.getClosedPRsList("closed")) {
                is ClientResult.InProgress -> {
                    _closedPrsList.emit(result)
                }
                is ClientResult.Success -> {
                    _closedPrsList.emit(result)
                    _isLoadingMLD.value = false
                }
                is ClientResult.Error -> {
                    _closedPrsList.emit(result)
                }
                else -> {}
            }
        }
    }
}