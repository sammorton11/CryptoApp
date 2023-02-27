package com.samm.cryptoapp.util.fakes.repository

import com.samm.cryptoapp.data.dto.CoinDto
import com.samm.cryptoapp.data.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.util.fakes.data.FakeDto.fakeCoinDetails
import com.samm.cryptoapp.util.fakes.data.FakeDto.fakeCoinPriceDetails
import com.samm.cryptoapp.util.fakes.data.FakeDto.fakeCoins

class FakeRepository : CryptoRepository {

    override suspend fun getCoinData(): List<CoinDto> {

        return fakeCoins
    }

    override suspend fun getCoinDetails(id: String): CoinDetailsDto {

        return fakeCoinDetails
    }

    override suspend fun getPriceCoinDetails(id: String): CoinPriceDetailsDtoItem {

        return fakeCoinPriceDetails
    }
}