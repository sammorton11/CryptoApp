package com.samm.cryptoapp.domain.repository

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem

interface CryptoRepository {

    // Get all Coin Data
    suspend fun getCoinData(): List<CoinDto>

    // Get Single Coin Details
    suspend fun getCoinDetails(id: String): CoinDetailsDto

    // Get Single Coin Details
    suspend fun getPriceCoinDetails(id: String): CoinPriceDetailsDtoItem
}