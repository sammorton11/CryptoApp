package com.samm.cryptoapp.domain.repository

import com.samm.cryptoapp.data.remote.dto.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.model.CoinData

interface CryptoRepository {

    // Get all Coin Data
    suspend fun getCoinData(): List<CoinDto>

    // Get Single Coin Details
    suspend fun getCoinDetails(id: String): CoinDetailsDto

    // Get Single Coin Details
    suspend fun getPriceCoinDetails(id: String): CoinPriceDetailsDtoItem
}