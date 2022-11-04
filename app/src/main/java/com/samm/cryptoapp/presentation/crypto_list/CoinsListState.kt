package com.samm.cryptoapp.presentation.crypto_list

import com.samm.cryptoapp.domain.model.CoinData

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<CoinData> = emptyList(),
    val error: String = ""
)
