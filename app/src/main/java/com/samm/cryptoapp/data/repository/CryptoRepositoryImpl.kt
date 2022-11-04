package com.samm.cryptoapp.data.repository

import com.samm.cryptoapp.data.remote.CryptoApi
import com.samm.cryptoapp.data.remote.dto.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(private val api: CryptoApi): CryptoRepository {

    override suspend fun getCoinData(): List<CoinDto> {
        return api.getCoinData()
    }

    override suspend fun getCoinDetails(id: String): CoinDetailsDto {
        return api.getCoinById(id)
    }

    override suspend fun getPriceCoinDetails(id: String): CoinPriceDetailsDtoItem {
        return api.getCoinPriceById(id)
    }
}