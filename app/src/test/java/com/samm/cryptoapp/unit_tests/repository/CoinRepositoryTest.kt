package com.samm.cryptoapp.unit_tests.repository

import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.data.remote.dto.CoinDto
import com.samm.cryptoapp.data.remote.dto.coin_details.toCoinDetail
import com.samm.cryptoapp.data.remote.dto.price_details.toCoinPriceDetail
import com.samm.cryptoapp.data.remote.dto.toCoin
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.fakes.FakeCryptoRepository
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId02
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId03
import com.samm.cryptoapp.util.fakes_test_shared.FakeGetAllCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CoinRepositoryTest {

    private var fakeRepository: FakeCryptoRepository = FakeCryptoRepository()
    private var getCoins: FakeGetAllCoinsUseCase = FakeGetAllCoinsUseCase()
    private lateinit var fakeUseCaseFlow: Flow<Resource<List<CoinData>>>
    private val coinIdList = listOf(fakeCoinId01, fakeCoinId02, fakeCoinId03)

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins()
    }

    @Test
    fun test_that_repository_is_not_empty(): Unit = runBlocking {
        // Test data is passed to the repository
        assertThat(fakeRepository).isNotNull()

    }

    @Test
    fun test_if_repository_data_from_DTO_exists(): Unit = runBlocking {
        val coinListDtoData = fakeRepository.getCoinData()

        coinIdList.forEach {
            assertThat(coinListDtoData).isNotNull()
            assertThat(coinListDtoData).isNotEmpty()
            assertThat(fakeRepository.getCoinDetails(it)).isNotNull()
            assertThat(fakeRepository.getPriceCoinDetails(it)).isNotNull()
        }

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
        val coinDetailsDtoData = fakeRepository.getCoinDetails(fakeCoinId01)
        val coinPriceDtoData = fakeRepository.getPriceCoinDetails(fakeCoinId02)

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