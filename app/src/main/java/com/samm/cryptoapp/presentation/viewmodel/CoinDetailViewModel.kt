package com.samm.cryptoapp.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.samm.cryptoapp.common.Constants.COIN_ID
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCase
import com.samm.cryptoapp.presentation.crypto_details_screen.CoinDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState()) // not exposed because mutable
    val state: State<CoinDetailsState> = _state // expose this to composable because immutable

    init {
        savedStateHandle.get<String>(COIN_ID)?.let { id ->
            getData(id)
        }
    }

    // method to call the use case - put the data in the state object - then display state in the ui
    private fun getData(id: String){

        // returns the flow that emits the Resource values
        // can call this class as a method because of overriding invoke() -- cool!
        // then use onEach to use the Resource result in the when expression
        // assign values to the state value
        getCoinDetailsUseCase(id).onEach { resourceResult ->

            when(resourceResult){
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coins = resourceResult.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(
                        error = resourceResult.message ?: "Unexpected Error"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope) // must launch in coroutine scope because using a flow
    }
}