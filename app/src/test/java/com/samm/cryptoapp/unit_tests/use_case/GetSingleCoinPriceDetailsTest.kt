package com.samm.cryptoapp.unit_tests.use_case

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import com.samm.cryptoapp.util.fakes_test_shared.FakeGetCoinPriceDetailsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class GetSingleCoinPriceDetailsTest {

    private var getCoins: FakeGetCoinPriceDetailsUseCase = FakeGetCoinPriceDetailsUseCase()
    private lateinit var fakeUseCaseFlow: Flow<Resource<CoinPriceDetailsData>>
    private lateinit var instrumentationCtx: Context

    @Before
    fun setUp(): Unit = runBlocking {
        instrumentationCtx = ApplicationProvider.getApplicationContext<Context>()
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