package com.samm.cryptoapp.presentation.crypto_details_screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.crypto_details_screen.components.*

@Composable
fun CoinDetailsScreenContent(
    navController: NavController,
    detailsState: CoinDetailsState,
    priceDetailsState: CoinPriceDetailsState
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
    ) {

        if(detailsState.error.isNotBlank() && priceDetailsState.error.isNotBlank()) {
            ErrorText(detailsState)
        }
        if(detailsState.isLoading || priceDetailsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        if(detailsState.coins != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 25.dp)
                    .verticalScroll(ScrollState(15))
            ) {

                detailsState.coins.let { coinData ->
                    Logo(coinData)
                    CoinPrice(priceDetailsState)
                    Description(coinData)
                    Team(coinData)
                    Tags(coinData)
                    ExploreLinks(coinData, navController)
                    SocialMediaLinks(coinData, navController)
                }
            }
        }
    }
}