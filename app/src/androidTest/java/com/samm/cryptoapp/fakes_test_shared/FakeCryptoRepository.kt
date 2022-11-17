package com.samm.cryptoapp.fakes

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.fakes.FakeDataSource.fakeCoinDetails
import com.samm.cryptoapp.fakes.FakeDataSource.fakeCoinPriceDetails
import com.samm.cryptoapp.fakes.FakeDataSource.fakeCoins

class FakeCryptoRepository: CryptoRepository {

    // use toCoin() in the fake view models
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