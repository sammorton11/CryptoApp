package com.samm.cryptoapp.unit_tests

import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.fakes.FakeCryptoRepository
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinName01
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinName02
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeCoinName03
import com.samm.cryptoapp.fakes.FakeGetAllCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllCoinsUseCaseTest {

    private var fakeRepository: FakeCryptoRepository = FakeCryptoRepository()
    private var getCoins: FakeGetAllCoinsUseCase = FakeGetAllCoinsUseCase()
    private lateinit var fakeUseCaseFlow: Flow<Resource<List<CoinData>>>

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins.getCoinsFakeResponse(fakeRepository)
    }

    @Test
    fun test_that_use_case_is_not_empty(): Unit = runBlocking {
        // Check that the data in the first emit in the fake use case flow is not empty
        assertThat(fakeUseCaseFlow.first().data).isNotNull()
    }

    @Test
    fun test_if_use_case_data_is_correct(): Unit = runBlocking {
        // Making sure data is passed to the use case
        assertThat(fakeUseCaseFlow.first().data?.get(0)?.name).isEqualTo(fakeCoinName01)
        assertThat(fakeUseCaseFlow.first().data?.get(1)?.name).isEqualTo(fakeCoinName02)
        assertThat(fakeUseCaseFlow.first().data?.get(2)?.name).isEqualTo(fakeCoinName03)
    }
}