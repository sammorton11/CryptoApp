package com.samm.cryptoapp.unit_tests.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Constants
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCase
import com.samm.cryptoapp.presentation.viewmodel.CoinDetailViewModel
import com.samm.cryptoapp.util.fakes.data.CoinDetailsScreenTestData.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.data.CoinListScreenTestData.fakeCoinId01
import com.samm.cryptoapp.util.fakes.use_case.FakeGetCoinDetailsUseCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinDetailsViewModelTest {

    private lateinit var viewModel: CoinDetailViewModel
    private lateinit var useCase: GetCoinDetailsUseCase
    private lateinit var coin: CoinDetailsData

    @Before
    fun setUp(){
        val savedState = SavedStateHandle(mapOf(Constants.COIN_ID to fakeCoinId01))
        useCase = FakeGetCoinDetailsUseCase()
        viewModel = CoinDetailViewModel(useCase, savedState)
        coin = viewModel.state.value.coins!!
    }

    @Test
    fun test_view_model_is_not_null() = assertThat(viewModel).isNotNull()


    @Test
    fun test_view_model_has_correct_data() {
        assertThat(coin.name).isEqualTo(fakeDetailNameExpanded)
    }
}