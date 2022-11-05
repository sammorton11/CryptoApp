package com.samm.cryptoapp.presentation.crypto_details

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.viewmodel.CoinDetailViewModel
import com.samm.cryptoapp.presentation.viewmodel.CoinPriceDetailViewModel

@Composable
fun CoinDetailsScreen(
    viewModelPrice: CoinPriceDetailViewModel = hiltViewModel(),
    viewModelInfo: CoinDetailViewModel = hiltViewModel(),
    navController: NavController,
    context: Context
) {
    val priceDetailsState = viewModelPrice.state.value
    val detailsState = viewModelInfo.state.value

    CoinDetailsScreenContent(detailsState, priceDetailsState, context)
}



