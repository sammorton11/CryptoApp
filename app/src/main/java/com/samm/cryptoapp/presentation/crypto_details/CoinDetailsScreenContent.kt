package com.samm.cryptoapp.presentation.crypto_details

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.presentation.crypto_details.components.*

@Composable
fun CoinDetailsScreenContent(
    detailsState: CoinDetailsState,
    priceDetailsState: CoinPriceDetailsState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        if(detailsState.error.isNotBlank() && priceDetailsState.error.isNotBlank()) {
            ErrorText(detailsState)
        }
        if(detailsState.isLoading || priceDetailsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 25.dp)
                    .verticalScroll(ScrollState(15))
            ) {

                detailsState.coins?.let { coinData ->
                    Logo(data = coinData)
                    Description(data = coinData, priceState = priceDetailsState)
                    Spacer(modifier = Modifier.padding(25.dp))
                    Tags(data = coinData)
                }
            }
        }
    }
}