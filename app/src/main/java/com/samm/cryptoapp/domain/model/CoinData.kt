package com.samm.cryptoapp.domain.model

data class CoinData(
    val id: String?,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
