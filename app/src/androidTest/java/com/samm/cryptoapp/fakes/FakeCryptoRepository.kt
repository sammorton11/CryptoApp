package com.samm.cryptoapp.fakes

import com.samm.cryptoapp.data.remote.dto.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.fakes.FakeNetworkCall.fakeCoinDetails
import com.samm.cryptoapp.fakes.FakeNetworkCall.fakeCoinPriceDetails
import com.samm.cryptoapp.fakes.FakeNetworkCall.fakeCoins

object FakeCryptoRepository: CryptoRepository {

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