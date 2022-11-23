package com.samm.cryptoapp.end_to_end

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.ui.theme.DarkGray
import com.samm.cryptoapp.presentation.ui.theme.TextWhite
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.backButton
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.is_active_text
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.test_title
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.BackButtonTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.CoinDetailsScreenTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListItemTags.CoinActivityTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListItemTags.CoinCardLabelsTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListItemTags.CoinCardTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.CoinListScreenTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.RefreshButtonTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.SearchFieldLabelTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.SearchFieldTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.TitleTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.TopBarTestTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test


/*
(Issues):
    - I think some of my end-to-end tests are integration tests
    - How to test network error?
    - Organize tests into separated inner classes - issue : throws errors
    - See CoinListDetails for other test issues - gather all issues and put into a read me file
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
                        Navigation(context = this)
                    }
                }
            }
        }
    }

    @Test
    fun test_title_visibility(){
        testVisibility(composeTestRule, TitleTestTag)
        textIsCorrect(composeTestRule, TitleTestTag, test_title)
    }

    @Test
    fun test_top_bar_visibility(){
        testVisibility(composeTestRule, TopBarTestTag)
        testColors(composeTestRule, TopBarTestTag, Color.Transparent)
    }

    @Test
    fun test_search_field_visibility(){
        testVisibility(composeTestRule, SearchFieldLabelTestTag)
        testColors(composeTestRule, SearchFieldLabelTestTag, TextWhite)
    }

    @Test
    fun test_search_field(){
        composeTestRule.waitForIdle()
        clickButton(composeTestRule, SearchFieldTestTag)
        clickButton(composeTestRule, SearchFieldTestTag)
        typeInText(composeTestRule, SearchFieldTestTag)
        wait(composeTestRule)
        /*
            Todo:
             - Check if search results label is displayed
         */
    }

    @Test
    fun test_refresh_button_visibility(){
        isClickable(composeTestRule, RefreshButtonTestTag)
        isDisplayed(composeTestRule, RefreshButtonTestTag)
        testColors(composeTestRule, RefreshButtonTestTag, DarkGray)
        /*
            Todo:
                Refresh button navigates to the main screen using the nav graph
                which triggers the use cases.
                - not sure how to test
                - may need to test this an integration test
         */
    }

    @Test
    fun test_coin_card_visibility(){
        isDisplayed(composeTestRule, CoinActivityTag)
        textIsCorrect(composeTestRule, CoinActivityTag, is_active_text)
        testColors(composeTestRule, CoinActivityTag, Color.Green)
        isClickable(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinCardLabelsTag)
        testColors(composeTestRule, CoinCardLabelsTag, TextWhite)
        textIsCorrect(composeTestRule, CoinCardLabelsTag, "1.  Bitcoin (BTC)")
    }

    @Test
    fun test_coin_card_functionality(){
        clickButton(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinDetailsScreenTag) // check if details screen is displayed
        scrollToTextElement(composeTestRule, backButton)
        isTextDisplayed(composeTestRule, backButton)
        clickButton(composeTestRule, BackButtonTestTag)
        isDisplayed(composeTestRule, CoinListScreenTag) // check if coin list screen is displayed
    }
}