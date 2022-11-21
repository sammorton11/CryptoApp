package com.samm.cryptoapp

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.backButton
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.expectedCardData
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.is_active_text
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.CoinListScreenFakes.test_title
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsTags.BackButtonTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListItemTags.CoinActivityTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListItemTags.CoinCardLabelsTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListItemTags.CoinCardTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListItemTags.CoinDetailsScreenTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListScreenTags.CoinListScreenTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListScreenTags.RefreshButtonTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListScreenTags.SearchFieldLabelTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListScreenTags.SearchFieldTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListScreenTags.TitleTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinListScreenTags.TopBarTestTag
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.ui.theme.DarkGray
import com.samm.cryptoapp.presentation.ui.theme.TextWhite
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/*
Todo:
    - Organize tests into separated inner classes - May want to migrate to JUnit5 to be able to use @Nested
    - Tests are passing so far
    - Search Field - verify that typing in the search field filters list?
    - Verify colors - background
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
        /*
            Todo: Issue - Not typing text in field
         */
    }

    @Test
    fun test_refresh_button_visibility(){
        isClickable(composeTestRule, RefreshButtonTestTag)
        isDisplayed(composeTestRule, RefreshButtonTestTag)
        testColors(composeTestRule, RefreshButtonTestTag, DarkGray)
        /*
            todo: ISSUE -
                Refresh button navigates to the main screen using the nav graph
                which triggers the use cases.
                - not sure how to test
                - may need to test this an integration test
         */
    }

    @Test
    fun test_coin_card_visibility(){
        isClickable(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinCardLabelsTag)
        testColors(composeTestRule, CoinCardLabelsTag, TextWhite)
        textIsCorrect(composeTestRule, CoinCardLabelsTag, expectedCardData)
    }

    @Test
    fun test_coin_card_functionality(){
        isDisplayed(composeTestRule, CoinActivityTag)
        textIsCorrect(composeTestRule, CoinActivityTag, is_active_text)
        testColors(composeTestRule, CoinActivityTag, Color.Green)
        clickButton(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinDetailsScreenTag) // check if details screen is displayed
        scrollToElement(composeTestRule, backButton)
        isTextDisplayed(composeTestRule, backButton)
        clickButton(composeTestRule, BackButtonTestTag)
        isDisplayed(composeTestRule, CoinListScreenTag) // check if coin list screen is displayed
        /*
            1. assert that active or inactive text is displayed with the correct colors on list screen
            2.
         */
    }
}