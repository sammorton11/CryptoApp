package com.samm.cryptoapp.unit_tests.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Constants
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetSingleCoinPriceUseCase
import com.samm.cryptoapp.presentation.viewmodel.CoinPriceDetailViewModel
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.circulating_supply
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.coin_price_test
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.max_supply
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeCoinId01
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeSymbol
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.firstCoinRank
import com.samm.cryptoapp.util.fakes.use_case.FakeGetCoinPriceDetailsUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinPriceDetailsViewModelTest {

    private lateinit var viewModel: CoinPriceDetailViewModel
    private lateinit var useCase: GetSingleCoinPriceUseCase
    private lateinit var coin: CoinPriceDetailsData

    @Before
    fun setUp(){
        val savedState = SavedStateHandle(mapOf(Constants.COIN_ID to fakeCoinId01))
        useCase = FakeGetCoinPriceDetailsUseCase()
        viewModel = CoinPriceDetailViewModel(useCase, savedState)
        coin = viewModel.state.value.coins!!
    }

    @Test
    fun test_view_model_is_not_null() = assertThat(viewModel).isNotNull()


    @Test
    fun test_view_model_has_correct_data() {
        assertThat(coin.name).isEqualTo(fakeDetailNameExpanded)
        assertThat(coin.id).isEqualTo(fakeCoinId01)
        assertThat(coin.symbol).isEqualTo(fakeSymbol)
        assertThat(coin.rank).isEqualTo(firstCoinRank)
        assertThat(coin.quotes.USD.price).isEqualTo(coin_price_test)
        assertThat(coin.circulating_supply).isEqualTo(circulating_supply)
        assertThat(coin.max_supply).isEqualTo(max_supply)
    }
}