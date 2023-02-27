package com.samm.cryptoapp.unit_tests.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.data.dto.CoinDto
import com.samm.cryptoapp.data.dto.coin_details.toCoinDetail
import com.samm.cryptoapp.data.dto.price_details.toCoinPriceDetail
import com.samm.cryptoapp.data.dto.toCoin
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.util.fakes.repository.FakeRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class CoinRepositoryTest {

    private var repository = FakeRepository()
    private val coinListDtoData = runBlocking { repository.getCoinData() }
    private val coinDetailsDtoData = runBlocking { repository.getCoinDetails("id") }
    private val coinPriceDetailsDtoData = runBlocking { repository.getPriceCoinDetails("id") }

    @Test
    fun test_that_getCoinData_is_not_empty(): Unit = runBlocking {
        assertThat(coinListDtoData).isNotEmpty()
    }
    @Test
    fun test_that_getCoinDetails_is_not_empty(): Unit = runBlocking {
        assertThat(coinDetailsDtoData).isNotNull()
    }
    @Test
    fun test_that_getPriceCoinDetails_is_not_empty(): Unit = runBlocking {
        assertThat(coinPriceDetailsDtoData).isNotNull()
    }

    @Test
    fun test_if_getCoinData_has_correct_data() {

        coinListDtoData.forEach {
            assertThat(it).isNotNull()

            assertThat(it.id).isNotNull()
            assertThat(it.id).isEqualTo("id")

            assertThat(it.name).isNotNull()
            assertThat(it.name).isEqualTo("Test Coin")

            assertThat(it.is_active).isNotNull()
            assertThat(it.is_active).isEqualTo(true)

            assertThat(it.rank).isNotNull()
            assertThat(it.rank).isEqualTo(1)

            assertThat(it.symbol).isNotNull()
            assertThat(it.symbol).isEqualTo("Test Symbol")

            assertThat(it.is_new).isNotNull()
            assertThat(it.is_new).isEqualTo(true)

            assertThat(it.type).isNotNull()
            assertThat(it.type).isEqualTo("Test Type")
        }


    }

    @Test
    fun test_if_getCoinDetails_has_correct_data(){
        assertThat(coinDetailsDtoData.id).isNotNull()



    }
    @Test
    fun test_if_getPriceCoinDetails_has_correct_data(){

    }


    @Test
    fun test_Dto_conversions() {

        coinListDtoData.map {
            val conversion =  it.toCoin()
            assertThat(conversion).isInstanceOf(CoinData::class.java)
            assertThat(conversion).isNotInstanceOf(CoinDto::class.java)
        }

        val conversionDetails = coinDetailsDtoData.toCoinDetail()
        assertThat(conversionDetails).isInstanceOf(CoinDetailsData::class.java)

        val conversionPrice = coinPriceDetailsDtoData.toCoinPriceDetail()
        assertThat(conversionPrice).isInstanceOf(CoinPriceDetailsData::class.java)
    }

}