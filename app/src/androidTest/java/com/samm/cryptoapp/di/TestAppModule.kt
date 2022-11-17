package com.samm.cryptoapp.di

import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.CoinDetailsDto
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinUseCase
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetAllCoinsUseCase
import com.samm.cryptoapp.fakes.FakeDataSource
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

    // Todo: Shouldn't have to provide this but fails without it
//    @Singleton
//    @Provides
//    fun provideApi(): CryptoApi {
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(CryptoApi::class.java)
//    }

    @Provides
    @Singleton
    fun provideFakeRepository() = object: CryptoRepository {

        // use toCoin() in the fake view models
        override suspend fun getCoinData(): List<CoinDto> {
            return FakeDataSource.fakeCoins
        }

        override suspend fun getCoinDetails(id: String): CoinDetailsDto {
            return FakeDataSource.fakeCoinDetails
        }

        override suspend fun getPriceCoinDetails(id: String): CoinPriceDetailsDtoItem {
            return FakeDataSource.fakeCoinPriceDetails
        }
    }


    @Provides
    @Singleton
    fun providesGetSingleCoinUseCase(repository: CryptoRepository): GetSingleCoinUseCase {
        return GetSingleCoinUseCase(repository)
    }
    @Provides
    @Singleton
    fun providesGetSingleCoinPriceUseCase(repository: CryptoRepository): GetSingleCoinPriceUseCase {
        return GetSingleCoinPriceUseCase(repository)
    }
    @Provides
    @Singleton
    fun providesGetAllCoinsUseCase(repository: CryptoRepository): GetAllCoinsUseCase {
        return GetAllCoinsUseCase(repository)
    }
}