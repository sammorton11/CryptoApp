package com.samm.cryptoapp

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.fakes_test_shared.TestTags
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsTags.CoinPriceTitleTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsTags.DescriptionTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsTags.DescriptionTitleTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsTags.MaxSupplyTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsTags.PriceCardTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange12hrLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange12hrTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange15mLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange15mTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1hrLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1hrTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1yrLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1yrTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange24hrLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange24hrTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30dLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30dTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30mLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30mTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange6hrLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange6hrTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange7dLabelTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange7dTag
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.ui.theme.TextWhite
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/*
    Todo:
     - Need fake image file for details page
     - Details cards are not expanding when clicked - tests only
 */

@HiltAndroidTest
@UninstallModules(AppModule::class)
class CoinDetailsScreenTest: BaseTest() {

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
        /*
             clicking the first card before each test to open the Card Details page
             feels hacky, but it works - will be changed
         */
        clickButton(composeTestRule, TestTags.CoinListItemTags.CoinCardTestTag)
    }

    @Test
    fun test_Price_Details_Visibility(){
        isDisplayed(composeTestRule, CoinPriceTitleTag)
        isDisplayed(composeTestRule, PriceCardTag)
        isClickable(composeTestRule, PriceCardTag)
        isDisplayed(composeTestRule, MaxSupplyTestTag)
        /*
            Todo: 1. assert no overlaps in text
         */
        isDisplayed(composeTestRule, PercentageChange15mTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange15mTag)
        isDisplayed(composeTestRule, PercentageChange15mLabelTag)
        testColors(composeTestRule, PercentageChange15mLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange30mTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange30mTag)
        isDisplayed(composeTestRule, PercentageChange30mLabelTag)
        testColors(composeTestRule, PercentageChange30mLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange1hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange1hrTag)
        isDisplayed(composeTestRule, PercentageChange1hrLabelTag)
        testColors(composeTestRule, PercentageChange1hrLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange6hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange6hrTag)
        isDisplayed(composeTestRule, PercentageChange6hrLabelTag)
        testColors(composeTestRule, PercentageChange6hrLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange12hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange12hrTag)
        isDisplayed(composeTestRule, PercentageChange12hrLabelTag)
        testColors(composeTestRule, PercentageChange12hrLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange24hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange24hrTag)
        isDisplayed(composeTestRule, PercentageChange24hrLabelTag)
        testColors(composeTestRule, PercentageChange24hrLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange7dTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange7dTag)
        isDisplayed(composeTestRule, PercentageChange7dLabelTag)
        testColors(composeTestRule, PercentageChange7dLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange30dTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange30dTag)
        isDisplayed(composeTestRule, PercentageChange30dLabelTag)
        testColors(composeTestRule, PercentageChange30dLabelTag, TextWhite)

        isDisplayed(composeTestRule, PercentageChange1yrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange1yrTag)
        isDisplayed(composeTestRule, PercentageChange1yrLabelTag)
        testColors(composeTestRule, PercentageChange1yrLabelTag, TextWhite)

    }

    // In-progress
    @Test
    fun test_Price_Details_Functionality(){
        isDisplayed(composeTestRule, CoinPriceTitleTag)
        testColors(composeTestRule, CoinPriceTitleTag, TextWhite)
        isClickable(composeTestRule, PriceCardTag)

        // Todo: Issue
        clickButton(composeTestRule, PriceCardTag) // should collapse card
        Thread.sleep(5000) // wait to view UI to see what's happening
        // this should not be visible after collapsing card
        isNotDisplayed(composeTestRule, MaxSupplyTestTag)

    }


    // In-progress
    @Test
    fun test_Description_Card_Visibility(){
        isDisplayed(composeTestRule, DescriptionTitleTag)
        textIsCorrect(composeTestRule, DescriptionTitleTag, "Description")
        testColors(composeTestRule, DescriptionTitleTag, TextWhite)
        isClickable(composeTestRule, DescriptionTag)

        // Todo: Issue
        clickButton(composeTestRule, DescriptionTag)
        Thread.sleep(5000) // wait to view UI to see what's happening
        // this should not be visible after collapsing card
    }

    @Test
    fun test_Team_Card_Visibility(){
        // Todo: Create tags for Team, Explore, and Social Media cards - change these func tags
        textIsCorrect(composeTestRule, DescriptionTitleTag, "Team")
        testColors(composeTestRule, DescriptionTitleTag, TextWhite)
        isClickable(composeTestRule, DescriptionTag)
    }

    @Test
    fun test_Team_Card_Functionality(){

    }

    @Test
    fun test_Tag_Card_Visibility(){

    }

    @Test
    fun test_Tag_Card_Functionality(){

    }

    @Test
    fun test_Explore_Card_Visibility(){

    }

    @Test
    fun test_Explore_Card_Functionality(){

    }

    @Test
    fun test_Social_Media_Card_Visibility(){

    }

    @Test
    fun test_Social_Media_Card_Functionality(){

    }
}