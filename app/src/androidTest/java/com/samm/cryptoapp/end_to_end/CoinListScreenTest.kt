package com.samm.cryptoapp.end_to_end

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.R
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.ui.theme.DarkGray
import com.samm.cryptoapp.presentation.ui.theme.TextWhite
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.active_text
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.expectedCardData
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinListScreenFakes.test_title
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.BackButtonTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.CoinDetailsScreenTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListItemTags.CoinCardLabelsTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListItemTags.CoinCardTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListItemTags.CoinStatusTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListScreenTags.CoinListScreenTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListScreenTags.RefreshButtonTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListScreenTags.TitleTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListScreenTags.TopBarTestTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/*
(Issues):
    - Refresh button
 */
@HiltAndroidTest
@UninstallModules(AppModule::class)
class CoinListScreenTest: BaseTest() {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)
    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp() {
        mainActivity = composeTestRule.activity
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

    @Test
    fun test_title_visibility(){
        isDisplayed(composeTestRule, TitleTestTag, mainActivity)
        textIsCorrect(composeTestRule, TitleTestTag, mainActivity, test_title)
    }

    @Test
    fun test_top_bar_visibility(){
        isDisplayed(composeTestRule, TopBarTestTag, mainActivity)
        testColors(composeTestRule, TopBarTestTag, mainActivity, Color.Transparent)
    }


    // in-progress
    @Test
    fun test_refresh_button_visibility(){
        isClickable(composeTestRule, RefreshButtonTestTag, mainActivity)
        isDisplayed(composeTestRule, RefreshButtonTestTag, mainActivity)
        testColors(composeTestRule, RefreshButtonTestTag, mainActivity, DarkGray)
    }

    @Test
    fun test_coin_card_visibility(){
        isDisplayed(composeTestRule, CoinStatusTag, mainActivity)
        textIsCorrect(composeTestRule, CoinStatusTag, mainActivity, active_text)
        testColors(composeTestRule, CoinStatusTag, mainActivity, Color.Green)
        isClickable(composeTestRule, CoinCardTestTag, mainActivity)
        isDisplayed(composeTestRule, CoinCardTestTag, mainActivity)
        isDisplayed(composeTestRule, CoinCardLabelsTag, mainActivity)
        testColors(composeTestRule, CoinCardLabelsTag, mainActivity, TextWhite)
        textIsCorrect(composeTestRule, CoinCardLabelsTag, mainActivity, expectedCardData)
    }

    @Test
    fun test_coin_card_functionality(){
        clickButton(composeTestRule, CoinCardTestTag, mainActivity)
        isDisplayed(composeTestRule, CoinDetailsScreenTag, mainActivity) // check if details screen is displayed
        scrollToTextElement(composeTestRule, R.string.backButtonLabel, mainActivity)
        isTextDisplayed(composeTestRule, R.string.backButtonLabel, mainActivity)
        clickButton(composeTestRule, BackButtonTestTag, mainActivity)
        isDisplayed(composeTestRule, CoinListScreenTag, mainActivity) // check if coin list screen is displayed
    }
}