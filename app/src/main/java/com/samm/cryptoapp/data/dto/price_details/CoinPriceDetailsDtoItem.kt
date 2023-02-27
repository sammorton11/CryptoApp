package com.samm.cryptoapp.data.dto.price_details

import com.samm.cryptoapp.domain.model.CoinPriceDetailsData

data class CoinPriceDetailsDtoItem(
    val beta_value: Double,
    val circulating_supply: Long,
    val first_data_at: String,
    val id: String,
    val last_updated: String,
    val max_supply: Long,
    val name: String,
    val quotes: Quotes,
    val rank: Int,
    val symbol: String,
    val total_supply: Long
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