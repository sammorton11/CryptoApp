package com.samm.cryptoapp.unit_tests.use_case

import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinName01
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinName02
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinName03
import com.samm.cryptoapp.util.fakes_test_shared.FakeGetAllCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllCoinsUseCaseTest {

    private var getCoins: FakeGetAllCoinsUseCase = FakeGetAllCoinsUseCase()
    private lateinit var fakeUseCaseFlow: Flow<Resource<List<CoinData>>>

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins()
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