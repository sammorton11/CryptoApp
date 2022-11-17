package com.samm.cryptoapp

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.crypto_list_screen.CoinListScreen
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test
/*
Todo: Test more things
  - Refresh Button
  - Top Bar
  - List Item - name, id, is_active, etc.
  - Results Text Label
  - Colors - make notes of the components colors then write tests to verify them
  - Title
 */
@HiltAndroidTest
@UninstallModules(AppModule::class)
class CoinListScreenTest: BaseTest() {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeTestRule.activity.apply{
            setContent {
                CryptoAppTheme {
                    Surface {
                        val context = LocalContext.current
                        val navController = rememberNavController()
                        val viewModel = hiltViewModel<CoinListViewModel>()
                        CoinListScreen(
                            navController = navController,
                            context = context,
                            viewModel = viewModel
                        )
                    }
                }
            }
        }
    }


    @Test
    fun test_first(){
       // composeTestRule.onNodeWithText("Bitcoin (BTC)").assertExists()
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithContentDescription("Search Field").assertExists()
        testVisibility(composeTestRule, "Search Field")
        Thread.sleep(5000)
    }
}