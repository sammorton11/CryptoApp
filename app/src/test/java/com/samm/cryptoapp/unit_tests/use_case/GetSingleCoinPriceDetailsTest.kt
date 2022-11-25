package com.samm.cryptoapp.unit_tests.use_case

import com.google.common.truth.Truth
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCaseImpl
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetSingleCoinPriceDetailsTest {

    @Mock
    private lateinit var getCoins: GetSingleCoinPriceUseCaseImpl
    private lateinit var fakeUseCaseFlow: Flow<Resource<CoinPriceDetailsData>>

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins(fakeCoinId01)
    }

    @Test
    fun test_that_use_case_is_not_empty(): Unit = runBlocking {
        // Check that the data in the first emit in the fake use case flow is not empty
        Truth.assertThat(fakeUseCaseFlow.first().data).isNotNull()
    }

    @Test
    fun test_if_use_case_data_is_correct(): Unit = runBlocking {
        Truth.assertThat(fakeUseCaseFlow.first().data?.name)
//            .isEqualTo(fakeDetailNameCollapsed)
            .isNotEmpty()
        Truth.assertThat(fakeUseCaseFlow.first().data?.id)
//            .isEqualTo(fakeDetailDescription)
            .isNotEmpty()
    }
}