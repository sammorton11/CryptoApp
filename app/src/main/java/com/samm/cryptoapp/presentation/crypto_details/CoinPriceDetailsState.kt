package com.samm.cryptoapp.presentation.crypto_details

import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData

data class CoinPriceDetailsState(
    val isLoading: Boolean = false,
    val coins: CoinPriceDetailsData? = null,
    val error: String = ""
)
