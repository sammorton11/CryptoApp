package com.samm.cryptoapp.presentation.crypto_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel


@Composable
fun MainScreen(viewModel: CoinListViewModel = hiltViewModel()) {

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins){
                Text(text = it.name)
            }

        }
        if (state.error.isNotBlank()){
            Text(text = state.error)
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }
    }

}