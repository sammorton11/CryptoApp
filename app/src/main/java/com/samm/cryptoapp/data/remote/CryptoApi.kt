package com.samm.cryptoapp.data.remote

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoApi {

    @GET("/v1/coins")
    suspend fun getCoinData(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") coinId: String
    ): CoinDetailsDto

    @GET("/v1/tickers/{coinId}")
    suspend fun getCoinPriceById(
        @Path("coinId") coinId: String
    ): CoinPriceDetailsDtoItem
}