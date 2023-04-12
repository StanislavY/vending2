package com.example.order.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.order.app.domain.usecase.AppState
import com.example.order.core.GlobalConstAndVars
import kotlinx.coroutines.*

class SaveViewModel(
    private val liveDataToObserve:MutableLiveData<AppState> = MutableLiveData(),

    ):ViewModel() {

    fun getDataFromServerForDB(): LiveData<AppState> {
        liveDataToObserve.value = AppState.Loading(null)
        return liveDataToObserve
    }
    fun awaiting()  {
        liveDataToObserve.value= AppState.Success(
            GlobalConstAndVars.DEFAULT_lIST
        )
        appCoroutineScope.launch {
            delay(3000)
        }

    }

    private val appCoroutineScope = CoroutineScope(
        Dispatchers.Default + SupervisorJob() + CoroutineExceptionHandler { _, _ ->
            handleError()
        })

    private fun handleError() {}





}