package com.samm.cryptoapp.util.fakes

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository

class FakeCryptoRepository: CryptoRepository {

    override suspend fun getCoinData(): List<CoinDto> {

        return FakeDataSource.FakeDto.fakeCoins
    }

    override suspend fun getCoinDetails(id: String): CoinDetailsDto {

        return FakeDataSource.FakeDto.fakeCoinDetails
    }

    override suspend fun getPriceCoinDetails(id: String): CoinPriceDetailsDtoItem {

        return FakeDataSource.FakeDto.fakeCoinPriceDetails
    }
}