package com.samm.cryptoapp.di

import com.samm.cryptoapp.common.Constants.BASE_URL
import com.samm.cryptoapp.data.remote.CryptoApi
import com.samm.cryptoapp.data.repository.CryptoRepositoryImpl
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCaseImpl
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCaseImpl
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApi(): CryptoApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: CryptoApi): CryptoRepository {
        return CryptoRepositoryImpl(api)
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