package com.samm.cryptoapp.unit_tests.use_case

import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.fakes.FakeCryptoRepository
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeDetailDescription
import com.samm.cryptoapp.fakes.FakeDataSource.FakeData.fakeDetailName
import com.samm.cryptoapp.fakes.FakeGetCoinDetailsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetCoinDetailsUseCaseTest {

    private var fakeRepository: FakeCryptoRepository = FakeCryptoRepository()
    private var getCoins: FakeGetCoinDetailsUseCase = FakeGetCoinDetailsUseCase()
    private lateinit var fakeUseCaseFlow: Flow<Resource<CoinDetailsData>>

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins.getCoinDetailsFakeResponse("fake_coin_01", fakeRepository)
    }

    @Test
    fun test_that_use_case_is_not_empty(): Unit = runBlocking {
        // Check that the data in the first emit in the fake use case flow is not empty
        assertThat(fakeUseCaseFlow.first().data).isNotNull()
    }

    @Test
    fun test_if_use_case_data_is_correct(): Unit = runBlocking {
        assertThat(fakeUseCaseFlow.first().data?.name).isEqualTo(fakeDetailName)
        assertThat(fakeUseCaseFlow.first().data?.description).isEqualTo(fakeDetailDescription)
    }
}