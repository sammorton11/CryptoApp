package com.samm.cryptoapp.integration

import android.app.Application
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.domain.use_case.get_list_of_coins.GetListOfCoinsUseCase
import com.samm.cryptoapp.presentation.crypto_list_screen.CoinListScreen
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.fakes.use_case.FakeGetListOfCoinsUseCase
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

// Todo: Test in progress

@HiltAndroidTest
@UninstallModules(AppModule::class)
class CoinListTest: BaseTest() {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var viewModel: CoinListViewModel
    private lateinit var useCase: GetListOfCoinsUseCase
    private lateinit var coins: List<CoinData>
    private lateinit var mainActivity: MainActivity
    private val context = getApplicationContext<Application>()
    private val navController = TestNavHostController(context)

    @Before
    fun setUp() {

        useCase = FakeGetListOfCoinsUseCase()
        viewModel = CoinListViewModel(useCase)
        coins = viewModel.state.value.coins

        mainActivity = composeTestRule.activity
        hiltRule.inject()
        composeTestRule.activity.apply {
            setContent {
                CryptoAppTheme {
                    Surface {
                        CoinListScreen(navController = navController, context = context)
                    }
                }
            }
        }
    }

    @Test
    fun test_data_exists() {
        wait(composeTestRule)
        composeTestRule.onNodeWithText(coins.first().name).assertIsDisplayed()
    }
}