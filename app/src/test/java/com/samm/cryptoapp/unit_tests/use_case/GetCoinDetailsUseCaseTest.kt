package com.samm.cryptoapp.unit_tests.use_case

import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailDescription
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameCollapsed
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import com.samm.cryptoapp.util.fakes_test_shared.FakeGetCoinDetailsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

open class GetCoinDetailsUseCaseTest {

    private var getCoins: FakeGetCoinDetailsUseCase = FakeGetCoinDetailsUseCase()
    private lateinit var fakeUseCaseFlow: Flow<Resource<CoinDetailsData>>

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins(fakeCoinId01)
    }

    @Test
    fun test_that_use_case_is_not_empty(): Unit = runBlocking {
        // Check that the data in the first emit in the fake use case flow is not empty
        assertThat(fakeUseCaseFlow.first().data).isNotNull()
    }

    @Test
    fun test_if_use_case_data_is_correct(): Unit = runBlocking {
        assertThat(fakeUseCaseFlow.first().data?.name).isEqualTo(fakeDetailNameCollapsed)
        assertThat(fakeUseCaseFlow.first().data?.description).isEqualTo(fakeDetailDescription)
    }
}