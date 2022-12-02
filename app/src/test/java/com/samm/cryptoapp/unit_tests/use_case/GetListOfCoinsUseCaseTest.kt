package com.samm.cryptoapp.unit_tests.use_case

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Resource
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.util.fakes.use_case.FakeGetListOfCoinsUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

// This test is complete

@RunWith(AndroidJUnit4::class)
class GetListOfCoinsUseCaseTest {

    private var getCoins: FakeGetListOfCoinsUseCase = FakeGetListOfCoinsUseCase()

    private lateinit var fakeUseCaseFlow: Flow<Resource<List<CoinData>>>
    private lateinit var coin: CoinData

    @Before
    fun setUp(): Unit = runBlocking {
        fakeUseCaseFlow = getCoins()
        coin = fakeUseCaseFlow.first().data?.get(0)!!

    }

    @Test
    fun test_that_use_case_is_not_empty(): Unit = runBlocking {
        assertThat(fakeUseCaseFlow.first().data).isNotNull()
    }

    @Test
    fun test_if_use_case_data_is_correct(): Unit = runBlocking {
        // Making sure data is passed to the use case
        assertThat(coin.id).isEqualTo("id")
        assertThat(coin.name).isEqualTo("Test Coin")
        assertThat(coin.is_active).isEqualTo(true)
        assertThat(coin.rank).isEqualTo(1)
        assertThat(coin.symbol).isEqualTo("Test Symbol")
    }
}