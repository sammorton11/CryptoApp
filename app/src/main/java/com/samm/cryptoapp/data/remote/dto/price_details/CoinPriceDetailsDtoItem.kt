package com.samm.cryptoapp.data.remote.dto.price_details

import com.samm.cryptoapp.data.remote.dto.CoinDetailsDto
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData

data class CoinPriceDetailsDtoItem(
    val beta_value: Double,
    val circulating_supply: Int,
    val first_data_at: String,
    val id: String,
    val last_updated: String,
    val max_supply: Int,
    val name: String,
    val quotes: Quotes,
    val rank: Int,
    val symbol: String,
    val total_supply: Int
)

// Map data from DTO to the CoinData data class
fun CoinPriceDetailsDtoItem.toCoinPriceDetail(): CoinPriceDetailsData{
    return CoinPriceDetailsData(
        beta_value,
        circulating_supply,
        first_data_at,
        id,
        last_updated,
        max_supply,
        name,
        quotes,
        rank,
        symbol,
        total_supply
    )
}