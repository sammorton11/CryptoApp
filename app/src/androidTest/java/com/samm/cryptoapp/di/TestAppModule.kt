package com.samm.cryptoapp.di

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCaseImpl
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCaseImpl
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCaseImpl
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeDto.fakeCoinDetails
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeDto.fakeCoinPriceDetails
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeDto.fakeCoins
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
@Module
object TestAppModule {

    @Provides
    @Singleton
    fun provideFakeRepository() = object: CryptoRepository {

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


    @Provides
    @Singleton
    fun providesGetSingleCoinUseCase(repository: CryptoRepository): GetCoinDetailsUseCase {
        return GetCoinDetailsUseCaseImpl(repository)
    }
    @Provides
    @Singleton
    fun providesGetSingleCoinPriceUseCase(repository: CryptoRepository): GetSingleCoinPriceUseCase {
        return GetSingleCoinPriceUseCaseImpl(repository)
    }
    @Provides
    @Singleton
    fun providesGetAllCoinsUseCase(repository: CryptoRepository): GetListOfCoinsUseCase {
        return GetListOfCoinsUseCaseImpl(repository)
    }
}