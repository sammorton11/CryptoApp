package com.samm.cryptoapp.unit_tests.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.samm.cryptoapp.common.Constants
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.use_case.get_coin_details_data.GetCoinDetailsUseCase
import com.samm.cryptoapp.presentation.viewmodel.CoinDetailViewModel
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailDescription
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeLogoUrl
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeMessage
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.fakeCoinId01
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.fakeSymbol
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.firstCoinRank
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.is_active
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.FakeLinksExtendedSuccess.fakeLinksExtended
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.fakeLink
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.fakeTag
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
        assertThat(coin.coinId).isEqualTo(fakeCoinId01)
        assertThat(coin.symbol).isEqualTo(fakeSymbol)
        assertThat(coin.rank).isEqualTo(firstCoinRank)
        assertThat(coin.description).isEqualTo(fakeDetailDescription)
        assertThat(coin.links).isEqualTo(fakeLink)
        assertThat(coin.isActive).isEqualTo(is_active)
        assertThat(coin.linksExtended).isEqualTo(fakeLinksExtended)
        assertThat(coin.logo).isEqualTo(fakeLogoUrl)
        assertThat(coin.message).isEqualTo(fakeMessage)
        assertThat(coin.tags).isEqualTo(listOf(fakeTag))
    }
}