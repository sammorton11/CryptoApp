package com.samm.cryptoapp.di

import com.samm.cryptoapp.common.Constants.BASE_URL
import com.samm.cryptoapp.data.remote.CryptoApi
import com.samm.cryptoapp.data.repository.CryptoRepositoryImpl
import com.samm.cryptoapp.domain.repository.CryptoRepository
import com.samm.cryptoapp.domain.use_case.get_all_coin_data.GetAllCoinsUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.domain.use_case.get_coin_data.GetSingleCoinUseCase
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
    fun providesGetSingleCoinUseCase(repository: CryptoRepository): GetSingleCoinUseCase{
        return GetSingleCoinUseCase(repository)
    }
    @Provides
    @Singleton
    fun providesGetSingleCoinPriceUseCase(repository: CryptoRepository): GetSingleCoinPriceUseCase{
        return GetSingleCoinPriceUseCase(repository)
    }
    @Provides
    @Singleton
    fun providesGetAllCoinsUseCase(repository: CryptoRepository): GetAllCoinsUseCase{
        return GetAllCoinsUseCase(repository)
    }
}