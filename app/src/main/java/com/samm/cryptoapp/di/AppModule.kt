package com.samm.cryptoapp.di

import com.samm.cryptoapp.common.Constants.BASE_URL
import com.samm.cryptoapp.data.remote.CryptoApi
import com.samm.cryptoapp.data.repository.CryptoRepositoryImpl
import com.samm.cryptoapp.domain.repository.CryptoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
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
}