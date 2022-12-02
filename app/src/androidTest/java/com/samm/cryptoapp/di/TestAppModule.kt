package com.samm.cryptoapp.di

import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCaseImpl
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCaseImpl
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCaseImpl
import com.samm.cryptoapp.util.fakes.FakeRepository
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


    // Repository
    @Provides
    @Singleton
    fun provideRepository(): CryptoRepository {
        return FakeRepository()
    }

    // Use Cases
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