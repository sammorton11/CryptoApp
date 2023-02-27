package com.samm.cryptoapp.data.dto.price_details

data class BTC(
    val ath_date: Any,
    val ath_price: Double,
    val market_cap: Int,
    val market_cap_change_24h: Double,
    val percent_change_12h: Double,
    val percent_change_15m: Double,
    val percent_change_1h: Double,
    val percent_change_1y: Double,
    val percent_change_24h: Double,
    val percent_change_30d: Double,
    val percent_change_30m: Double,
    val percent_change_6h: Double,
    val percent_change_7d: Double,
    val percent_from_price_ath: Double,
    val price: Double,
    val volume_24h: Double,
    val volume_24h_change_24h: Double
)