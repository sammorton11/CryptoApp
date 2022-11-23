package com.samm.cryptoapp.integration

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.fakes_test_shared.TestTags
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
        composeTestRule.activity.apply{
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
        Navigate to the Details screen when coin card is clicked
     */
    @Test
    fun test_navigateToCoinDetailsScreen() {
        clickButton(composeTestRule, TestTags.CoinListItemTags.CoinCardTestTag)
        isDisplayed(composeTestRule, TestTags.CoinDetailsTags.CoinDetailsScreenTag)
    }
}