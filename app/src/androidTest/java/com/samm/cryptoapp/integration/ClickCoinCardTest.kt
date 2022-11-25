package com.samm.cryptoapp.integration

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.BackButtonTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.CoinDetailsScreenTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListItemTags.CoinCardTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.CoinListScreenTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class ClickCoinCardTest: BaseTest() {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
        composeTestRule.activity.apply {
            setContent {
                CryptoAppTheme {
                    Surface {
                        Navigation(context = this)
                    }
                }
            }
        }
    }
    /*
        Test that clicking the Coin Card opens the Coin Details Screen and the Back Button returns
        the user back to the main screen.
     */
    @Test
    fun test_navigateToCoinDetailsScreen() {
        clickButton(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinDetailsScreenTag)
        scrollToElementWithTag(composeTestRule, BackButtonTestTag)
        clickButton(composeTestRule, BackButtonTestTag)
        isDisplayed(composeTestRule, CoinListScreenTag)
    }
}