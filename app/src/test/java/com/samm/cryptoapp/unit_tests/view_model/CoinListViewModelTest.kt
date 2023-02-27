package com.samm.cryptoapp.unit_tests.view_model

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeCoinId01
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeSymbol
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.firstCoinRank
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.is_active
import com.samm.cryptoapp.util.fakes.use_case.FakeGetListOfCoinsUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinListViewModelTest {

    private lateinit var viewModel: CoinListViewModel
    private lateinit var useCase: GetListOfCoinsUseCase
    private lateinit var coin: CoinData

    @Before
    fun setUp(){
        useCase = FakeGetListOfCoinsUseCase()
        viewModel = CoinListViewModel(useCase)
        coin = viewModel.state.value.coins.first()
    }

    @Test
    fun test_view_model_is_not_null() = assertThat(viewModel).isNotNull()


    @Test
    fun test_view_model_has_correct_data() {
        assertThat(coin.name).isEqualTo(fakeDetailNameExpanded)
        assertThat(coin.id).isEqualTo(fakeCoinId01)
        assertThat(coin.symbol).isEqualTo(fakeSymbol)
        assertThat(coin.rank).isEqualTo(firstCoinRank)
        assertThat(coin.is_active).isEqualTo(is_active)
    }
}