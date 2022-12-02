package com.samm.cryptoapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import com.samm.cryptoapp.presentation.crypto_list_screen.CoinsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getAllCoinsUseCase: GetListOfCoinsUseCase
): ViewModel() {

    private val _state = mutableStateOf(CoinsListState()) // not exposed because mutable
    val state: State<CoinsListState> = _state // expose this to composable because immutable

    init {
        getData()
    }

    // method to call the use case - put the data in the state object - then display state in the ui
    private fun getData(){

        getAllCoinsUseCase().onEach { resourceResult ->

            when(resourceResult){
                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinsListState(coins = resourceResult.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinsListState(
                        error = resourceResult.message ?: "Unexpected Error"
                    )
                }
            }
        }.launchIn(viewModelScope) // must launch in coroutine scope because using a flow
    }

    private var lastRefreshTime = 0
    fun onRefreshDataEvent() {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastRefreshTime > (1000 * 60)) {
            getData()
            lastRefreshTime = currentTime.toInt()
        }
    }
}