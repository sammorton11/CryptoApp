package com.samm.cryptoapp.presentation.crypto_details_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.viewmodel.CoinDetailViewModel
import com.samm.cryptoapp.presentation.viewmodel.CoinPriceDetailViewModel

@Composable
fun CoinDetailsScreen(
    viewModelPrice: CoinPriceDetailViewModel = hiltViewModel(),
    viewModelInfo: CoinDetailViewModel = hiltViewModel(),
    navController: NavController
) {
    val priceDetailsState = viewModelPrice.state.value
    val detailsState = viewModelInfo.state.value

    CoinDetailsScreenContent(navController, detailsState, priceDetailsState)
}



