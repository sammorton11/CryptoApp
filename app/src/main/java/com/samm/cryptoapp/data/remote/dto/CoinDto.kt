package com.samm.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.samm.cryptoapp.domain.model.CoinData

// Use this to map data from api - then use the CoinData data class in model package for the UI
data class CoinDto(
    val id: String?,
    @SerializedName("is_active")
    val is_active: Boolean,
    @SerializedName("is_new")
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

// Map data from DTO to the CoinData data class
fun CoinDto.toCoin(): CoinData {
    return CoinData(
        id = id,
        is_active = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}