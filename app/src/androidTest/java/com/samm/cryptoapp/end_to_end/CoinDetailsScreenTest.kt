package com.samm.cryptoapp.end_to_end

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.R
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.ui.theme.DarkGray
import com.samm.cryptoapp.presentation.ui.theme.TextWhite
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.TestContext.appContext
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.description_card_title
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.explore_card_title
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameCollapsed
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.social_media_card_title
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.tags_card_title
import com.samm.cryptoapp.util.fakes.FakeDataSource.FakeData.CoinDetailsScreenFakes.team_card_title
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.BackButtonTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.CoinPriceTitleTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.DescriptionTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.DescriptionTextTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.DescriptionTitleExpandedTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.DescriptionTitleTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.ExploreCardTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.ExploreTitleTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.MaxSupplyTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.PriceCardDetailsTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.PriceCardTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.SocialMediaTitleTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.SocialMedialCardTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.TagsCardTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.TagsDetailsTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.TagsTitleTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.TeamCardTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.TeamDetailsTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.TeamTitleTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinDetailsTags.exploreCardTitle
import com.samm.cryptoapp.util.fakes.TestTags.CoinListItemTags.CoinCardTestTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinListScreenTags.CoinListScreenTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange12hrLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange12hrTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange15mLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange15mTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange1hrLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange1hrTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange1yrLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange1yrTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange24hrLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange24hrTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange30dLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange30dTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange30mLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange30mTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange6hrLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange6hrTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange7dLabelTag
import com.samm.cryptoapp.util.fakes.TestTags.CoinPriceDetailsTags.PercentageChange7dTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/*
      Hilt test for the Coin Details Screen. Inherits from the base test for all test methods.
      Each method takes a resource id to identify the component in test.

 */


/*
    Todo:
     - 'Not displayed' methods not working properly
     - assert no overlaps in text
     - Would like to put test functions for each UI component within their own inner classes
       but it throws errors.
     - assert that the card details are not displayed when collapsed
 */

/*
(Issues):
  - Test links not showing up in semantics tree and are failing isDisplayed tests but are verified
    to be displayed when manual testing - passing 'exists' tests
  - isNotDisplayed tests for card details still fail after collapsing card - confused
  - Cannot create inner test classes without throwing errors
  - Cannot share fakes/test doubles between androidTest and test packages - Data Models are used in fakes
 */


@HiltAndroidTest
@UninstallModules(AppModule::class)
class CoinDetailsScreenTest: BaseTest() {

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
                        Navigation(context = appContext)
                    }
                }
            }
        }
        /*
             clicking the first card before each test to open the Card Details page.
             kinda hacky, but it works for now.
         */
        clickButton(composeTestRule, CoinCardTestTag, mainActivity)
        wait(composeTestRule)
    }

    @Test
    fun test_company_logo(){
        Thread.sleep(6000)
        existsTestTag(composeTestRule, R.string.company_logo_tag, mainActivity)
        isDisplayed(composeTestRule, R.string.company_logo_tag, mainActivity)
        isDisplayed(composeTestRule, R.string.company_logo_tag, mainActivity)
    }

    @Test
    fun test_Price_Card_Visibility(){

        existsTestTag(composeTestRule, CoinPriceTitleTag, mainActivity)
        existsTestTag(composeTestRule, PriceCardTag, mainActivity)
        isClickable(composeTestRule, PriceCardTag, mainActivity)
        isDisplayed(composeTestRule, CoinPriceTitleTag, composeTestRule.activity)
        isDisplayed(composeTestRule, PriceCardTag, composeTestRule.activity)
        isDisplayed(composeTestRule, PriceCardDetailsTag, composeTestRule.activity)
        isDisplayed(composeTestRule, MaxSupplyTestTag, composeTestRule.activity)
        testColors(composeTestRule, CoinPriceTitleTag, composeTestRule.activity, TextWhite)
        testColors(composeTestRule, MaxSupplyTestTag, mainActivity, TextWhite)

        // Percentage change over 15m text
        existsTestTag(composeTestRule, PercentageChange15mTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange15mLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange15mTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange15mTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange15mLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange15mLabelTag, mainActivity, TextWhite)

        // Percentage change over 30m text
        existsTestTag(composeTestRule, PercentageChange30mTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange30mLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange30mTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange30mTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange30mLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange30mLabelTag, mainActivity, TextWhite)

        // Percentage change over 1hr text
        existsTestTag(composeTestRule, PercentageChange1hrTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange1hrLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange1hrTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange1hrTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange1hrLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange1hrLabelTag, mainActivity, TextWhite)

        // Percentage change over 6hr text
        existsTestTag(composeTestRule, PercentageChange6hrTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange6hrLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange6hrTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange6hrTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange6hrLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange6hrLabelTag, mainActivity, TextWhite)

        // Percentage change over 12hr text
        existsTestTag(composeTestRule, PercentageChange12hrTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange12hrLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange12hrTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange12hrTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange12hrLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange12hrLabelTag, mainActivity, TextWhite)

        // Percentage change over 24hr text
        existsTestTag(composeTestRule, PercentageChange24hrTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange24hrLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange24hrTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange24hrTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange24hrLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange24hrLabelTag, mainActivity, TextWhite)

        // Percentage change over 7d text
        existsTestTag(composeTestRule, PercentageChange7dTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange7dLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange7dTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange7dTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange7dLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange7dLabelTag, mainActivity, TextWhite)

        // Percentage change over 30d text
        existsTestTag(composeTestRule, PercentageChange30dTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange30dLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange30dTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange30dTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange30dLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange30dLabelTag, mainActivity, TextWhite)

        // Percentage change over 1yr text
        existsTestTag(composeTestRule, PercentageChange1yrTag, mainActivity)
        existsTestTag(composeTestRule, PercentageChange1yrLabelTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange1yrTag, mainActivity)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange1yrTag, mainActivity)
        isDisplayed(composeTestRule, PercentageChange1yrLabelTag, mainActivity)
        testColors(composeTestRule, PercentageChange1yrLabelTag, mainActivity, TextWhite)

    }

    @Test
    fun test_Price_Card_Functionality(){
        // Price card is already expanded
        clickButton(composeTestRule, PriceCardTag, mainActivity)
        // assert that price details are not displayed
        isNotDisplayed(composeTestRule, PriceCardTag, mainActivity) // this throws errors
    }

    @Test
    fun test_Description_Card_Visibility(){
        existsTestTag(composeTestRule, DescriptionTitleTag, mainActivity)
        existsTestTag(composeTestRule, DescriptionTag, mainActivity)
        isDisplayed(composeTestRule, DescriptionTitleTag, mainActivity)
        isDisplayed(composeTestRule, DescriptionTag, mainActivity)
        isClickable(composeTestRule, DescriptionTag, mainActivity)
        textIsCorrect(composeTestRule, DescriptionTitleTag, mainActivity, description_card_title)
        testColors(composeTestRule, DescriptionTitleTag, mainActivity, TextWhite)
        testColors(composeTestRule, DescriptionTag, mainActivity, DarkGray)
    }

    @Test
    fun test_Description_Card_Functionality(){

        existsTestTag(composeTestRule, DescriptionTextTag, mainActivity)
        existsTestTag(composeTestRule, DescriptionTag, mainActivity)

        clickButton(composeTestRule, DescriptionTag, mainActivity) // expand card
        wait(composeTestRule)
        Thread.sleep(8000)
        textIsCorrect(
            composeTestRule,
            DescriptionTitleExpandedTag,
            mainActivity,
            fakeDetailNameExpanded
        )
        isDisplayed(composeTestRule, DescriptionTextTag, mainActivity) // details
        existsTestTag(composeTestRule, DescriptionTextTag, mainActivity)
        clickButton(composeTestRule, DescriptionTag, mainActivity) // collapse card
        textIsCorrect(
            composeTestRule,
            DescriptionTitleTag,
            mainActivity, fakeDetailNameCollapsed
        )
        doesNotExistTestTag(composeTestRule, DescriptionTextTag, mainActivity)

    }

    @Test
    fun test_Team_Card_Visibility(){

        existsTestTag(composeTestRule, TeamTitleTestTag, mainActivity)
        existsTestTag(composeTestRule, TeamCardTestTag, mainActivity)

        isDisplayed(composeTestRule, TeamTitleTestTag, mainActivity)
        isDisplayed(composeTestRule, TeamCardTestTag, mainActivity)

        isClickable(composeTestRule, TeamCardTestTag, mainActivity)
        textIsCorrect(composeTestRule, TeamTitleTestTag, mainActivity, team_card_title)

        testColors(composeTestRule, TeamTitleTestTag, mainActivity, TextWhite)
        testColors(composeTestRule, TeamCardTestTag, mainActivity, DarkGray)
    }

    @Test
    fun test_Team_Card_Functionality(){

        existsTestTag(composeTestRule, TagsCardTag, mainActivity)
        existsTestTag(composeTestRule, TagsTitleTag, mainActivity)
        existsTestTag(composeTestRule, TeamDetailsTestTag, mainActivity)
        isDisplayed(composeTestRule, TagsTitleTag, mainActivity) // Todo: start here - go over this test

        clickButton(composeTestRule, TeamCardTestTag, mainActivity) // expand card
        isDisplayed(composeTestRule, TeamDetailsTestTag, mainActivity) // details

        clickButton(composeTestRule, TeamCardTestTag, mainActivity) // collapse card
        isNotDisplayed(composeTestRule, TeamDetailsTestTag, mainActivity)
    }

    @Test
    fun test_Tag_Card_Visibility(){
        scrollToElementWithTag(composeTestRule, TagsCardTag, mainActivity)
        existsTestTag(composeTestRule, TagsTitleTag, mainActivity)
        existsTestTag(composeTestRule, TagsCardTag, mainActivity)
        isDisplayed(composeTestRule, TagsTitleTag, mainActivity)
        isDisplayed(composeTestRule, TagsCardTag, mainActivity)
        isClickable(composeTestRule, TagsCardTag, mainActivity)
        textIsCorrect(composeTestRule, TagsTitleTag, mainActivity, tags_card_title)
        testColors(composeTestRule, TagsTitleTag, mainActivity, TextWhite)
        testColors(composeTestRule, TagsCardTag, mainActivity, DarkGray)
    }

    @Test
    fun test_Tag_Card_Functionality(){
        scrollToElementWithTag(composeTestRule, TagsCardTag, mainActivity)
        clickButton(composeTestRule, TagsCardTag, mainActivity) // expand card
        wait(composeTestRule)
        existsTestTag(composeTestRule, TagsDetailsTag, mainActivity)
        isDisplayed(composeTestRule, TagsDetailsTag, mainActivity) // details
        clickButton(composeTestRule, TagsCardTag, mainActivity) // collapse card
        isNotDisplayed(composeTestRule, TeamDetailsTestTag, mainActivity)
    }

    @Test
    fun test_Explore_Card_Visibility(){
        existsTestTag(composeTestRule, ExploreTitleTag, mainActivity)
        existsTestTag(composeTestRule, ExploreCardTag, mainActivity)
        scrollToElementWithTag(composeTestRule, ExploreTitleTag, mainActivity)
        textIsCorrect(composeTestRule, ExploreTitleTag, mainActivity, explore_card_title)
        isDisplayed(composeTestRule, ExploreTitleTag, mainActivity)
        isDisplayed(composeTestRule, ExploreCardTag, mainActivity)
        isClickable(composeTestRule, ExploreCardTag, mainActivity)
        testColors(composeTestRule, ExploreTitleTag, mainActivity, TextWhite)
        testColors(composeTestRule, ExploreCardTag, mainActivity, DarkGray)
    }

    @Test
    fun test_Explore_Card_Functionality(){

        scrollToTextElement(composeTestRule, exploreCardTitle, mainActivity)
        clickButton(composeTestRule, ExploreCardTag, mainActivity) // expand card
        wait(composeTestRule)

        existsText(composeTestRule, R.string.test_link_extended_url_text, mainActivity)
//        scrollToTextElement(composeTestRule, test_link_extended_url, mainActivity)
//        isDisplayed(composeTestRule, test_link_extended_url, mainActivity) // details
//        clickButton(composeTestRule, ExploreCardTag, mainActivity) // collapse card
//        isTextNotDisplayed(composeTestRule, test_link_extended_url, mainActivity)
    }

    @Test
    fun test_Social_Media_Card_Visibility(){

        existsTestTag(composeTestRule, SocialMediaTitleTag, mainActivity)
        scrollToElementWithTag(composeTestRule, SocialMediaTitleTag, mainActivity)
        textIsCorrect(composeTestRule, SocialMediaTitleTag, mainActivity, social_media_card_title)
        isDisplayed(composeTestRule, SocialMediaTitleTag, mainActivity)
        testColors(composeTestRule, SocialMediaTitleTag, mainActivity, TextWhite)

        existsTestTag(composeTestRule, SocialMedialCardTag, mainActivity)
        isClickable(composeTestRule, SocialMedialCardTag, mainActivity)
        testColors(composeTestRule, SocialMedialCardTag, mainActivity, DarkGray)
    }

    @Test
    fun test_Social_Media_Card_Functionality(){

        scrollToElementWithTag(composeTestRule, SocialMedialCardTag, mainActivity)
        wait(composeTestRule)
        clickButton(composeTestRule, SocialMedialCardTag, mainActivity) // expand card
        wait(composeTestRule)

        existsText(composeTestRule, R.string.test_explorer_link, mainActivity)
        existsText(composeTestRule, R.string.test_facebook_link, mainActivity)
        existsText(composeTestRule, R.string.test_medium_link, mainActivity)
        existsText(composeTestRule, R.string.test_reddit_link, mainActivity)
        existsText(composeTestRule, R.string.test_source_code_link, mainActivity)
        existsText(composeTestRule, R.string.test_website_link, mainActivity)
        existsText(composeTestRule, R.string.test_youtube_link, mainActivity)

        isTextDisplayed(composeTestRule, R.string.test_explorer_link, mainActivity)
        isTextDisplayed(composeTestRule, R.string.test_facebook_link, mainActivity)
        isTextDisplayed(composeTestRule, R.string.test_medium_link, mainActivity)
        isTextDisplayed(composeTestRule, R.string.test_reddit_link, mainActivity)
        isTextDisplayed(composeTestRule, R.string.test_source_code_link, mainActivity)
        isTextDisplayed(composeTestRule, R.string.test_website_link, mainActivity)
        isTextDisplayed(composeTestRule, R.string.test_youtube_link, mainActivity)

        clickButton(composeTestRule, SocialMedialCardTag, mainActivity) // collapse card

        isTextNotDisplayed(composeTestRule, R.string.test_explorer_link, mainActivity)
        isTextNotDisplayed(composeTestRule, R.string.test_facebook_link, mainActivity)
        isTextNotDisplayed(composeTestRule, R.string.test_medium_link, mainActivity)
        isTextNotDisplayed(composeTestRule, R.string.test_reddit_link, mainActivity)
        isTextNotDisplayed(composeTestRule, R.string.test_source_code_link, mainActivity)
        isTextNotDisplayed(composeTestRule, R.string.test_website_link, mainActivity)
        isTextNotDisplayed(composeTestRule, R.string.test_youtube_link, mainActivity)
    }

    @Test
    fun back_button_visibility(){
        existsTestTag(composeTestRule, BackButtonTestTag, mainActivity)
        scrollToElementWithTag(composeTestRule, BackButtonTestTag, mainActivity)
        isDisplayed(composeTestRule, BackButtonTestTag, mainActivity)
        isClickable(composeTestRule, BackButtonTestTag, mainActivity)
    }

    @Test
    fun back_button_functionality(){
        scrollToElementWithTag(composeTestRule, BackButtonTestTag, mainActivity)
        clickButton(composeTestRule, BackButtonTestTag, mainActivity)
        isDisplayed(composeTestRule, CoinListScreenTag, mainActivity) // is on coin list screen
    }
}