package com.samm.cryptoapp.unit_tests.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.data.remote.CryptoApi
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.toCoinDetail
import com.samm.cryptoapp.data.remote.dto.price_details.toCoinPriceDetail
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.data.repository.CryptoRepositoryImpl
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.domain.repository.CryptoRepository
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


// COMPLETE
@RunWith(AndroidJUnit4::class)
class CoinRepositoryTest {

    val data = mockk<CryptoApi>(relaxed = true)
    lateinit var fakeRepository: CryptoRepository

    @Before
    fun setUp(): Unit = runBlocking {
        fakeRepository = CryptoRepositoryImpl(data)
    }

    @Test
    fun test_that_repository_is_not_empty(): Unit = runBlocking {
        assertThat(fakeRepository).isNotNull()
    }

    @Test
    fun test_if_repository_data_from_DTO_exists(): Unit = runBlocking {
        val coinListDtoData = fakeRepository.getCoinData()

        coinListDtoData.forEach {
            assertThat(it).isNotNull()
            assertThat(it.id).isNotNull()
            assertThat(it.name).isNotNull()
            assertThat(it.is_active).isNotNull()
            assertThat(it.rank).isNotNull()
            assertThat(it.symbol).isNotNull()
            assertThat(it.is_new).isNotNull()
            assertThat(it.type).isNotNull()
        }
    }


    @Test
    fun test_Dto_conversions(): Unit = runBlocking {
        val coinListDtoData = fakeRepository.getCoinData()

        // these do not need actual ID's - we are just testing that the DTOs are converted correctly
        val coinDetailsDtoData = fakeRepository.getCoinDetails("")
        val coinPriceDtoData = fakeRepository.getPriceCoinDetails("")

        coinListDtoData.map {
            val conversion =  it.toCoin()
            assertThat(conversion).isInstanceOf(CoinData::class.java)
            assertThat(conversion).isNotInstanceOf(CoinDto::class.java)
        }

        val conversionDetails = coinDetailsDtoData.toCoinDetail()
        assertThat(conversionDetails).isInstanceOf(CoinDetailsData::class.java)

        val conversionPrice = coinPriceDtoData.toCoinPriceDetail()
        assertThat(conversionPrice).isInstanceOf(CoinPriceDetailsData::class.java)
    }
}