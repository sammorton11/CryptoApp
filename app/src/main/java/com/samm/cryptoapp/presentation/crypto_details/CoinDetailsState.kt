package com.samm.cryptoapp.presentation.crypto_details

import com.samm.cryptoapp.domain.model.CoinDetailsData

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coins: CoinDetailsData? = null,
    val error: String = ""
)
