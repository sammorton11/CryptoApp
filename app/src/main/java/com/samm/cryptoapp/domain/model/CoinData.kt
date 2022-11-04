package com.samm.cryptoapp.domain.model

import com.google.gson.annotations.SerializedName

data class CoinData(
    val id: String,
    val is_active: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String
)
