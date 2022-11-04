package com.samm.cryptoapp.data.remote.dto.price_details

data class BTC(
    val ath_date: Any,
    val ath_price: Any,
    val market_cap: Int,
    val market_cap_change_24h: Double,
    val percent_change_12h: Int,
    val percent_change_15m: Int,
    val percent_change_1h: Int,
    val percent_change_1y: Int,
    val percent_change_24h: Int,
    val percent_change_30d: Int,
    val percent_change_30m: Int,
    val percent_change_6h: Int,
    val percent_change_7d: Int,
    val percent_from_price_ath: Any,
    val price: Int,
    val volume_24h: Double,
    val volume_24h_change_24h: Double
)