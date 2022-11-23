package com.samm.cryptoapp.end_to_end

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.presentation.ui.theme.DarkGray
import com.samm.cryptoapp.presentation.ui.theme.TextWhite
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.TestContext.appContext
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameCollapsed
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeDetailNameExpanded
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.fakeTeamMemberName
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_explorer
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_facebook
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_link_extended_url
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_medium
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_reddit
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_source_code
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_website
import com.samm.cryptoapp.util.fakes_test_shared.FakeDataSource.FakeData.CoinDetailsScreenFakes.test_youtube
import com.samm.cryptoapp.util.fakes_test_shared.TestTags
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.BackButtonTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.CoinPriceTitleTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.CompanyLogoTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.DescriptionTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.DescriptionTextTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.DescriptionTitleExpandedTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.DescriptionTitleTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.ExploreCardTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.ExploreTitleTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.MaxSupplyTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.PriceCardTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.SocialMediaTitleTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.SocialMedialCardTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.TagsCardTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.TagsDetailsTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.TagsTitleTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.TeamCardTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.TeamDetailsTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinDetailsTags.TeamTitleTestTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinListScreenTags.CoinListScreenTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange12hrLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange12hrTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange15mLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange15mTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1hrLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1hrTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1yrLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange1yrTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange24hrLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange24hrTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30dLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30dTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30mLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange30mTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange6hrLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange6hrTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange7dLabelTag
import com.samm.cryptoapp.util.fakes_test_shared.TestTags.CoinPriceDetailsTags.PercentageChange7dTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/*
    Todo:
     - 'Not displayed' methods not working properly - it fails assertExists but I'm using assertDoesNotExist?
     - assert no overlaps in text
     - Would like to put test functions for each UI component within their own inner classes but it throws errors
     - Test functionality for Team, Tags, Social Media, Explore cards
     - click card make sure that text is displayed when expanded and not displayed when collapsed
 */

/*
(Issues):
  - Test links not showing up in semantics tree and are failing isDisplayed tests but are verified
  - to be displayed when manual testing - passing 'exists' tests
  - isNotDisplayed tests for card details still fail after collapsing card - confused
  - Cannot create inner test classes without throwing errors
  - Cannot share fakes/test doubles between androidTest and test packages
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
                        Navigation(context = appContext)
                    }
                }
            }
        }
        /*
             clicking the first card before each test to open the Card Details page
             feels hacky, but it works - will be changed
         */
        clickButton(composeTestRule, TestTags.CoinListItemTags.CoinCardTestTag)
        wait(composeTestRule)
    }

    @Test
    fun test_company_logo(){
        existsTestTag(composeTestRule, CompanyLogoTag)
        isDisplayed(composeTestRule, CompanyLogoTag)
    }

    @Test
    fun test_Price_Card_Visibility(){

        isClickable(composeTestRule, PriceCardTag)
        existsTestTag(composeTestRule, CoinPriceTitleTag)
        existsTestTag(composeTestRule, PriceCardTag)
        isDisplayed(composeTestRule, CoinPriceTitleTag)
        isDisplayed(composeTestRule, PriceCardTag)
        isDisplayed(composeTestRule, MaxSupplyTestTag)
        testColors(composeTestRule, CoinPriceTitleTag, TextWhite)
        testColors(composeTestRule, MaxSupplyTestTag, TextWhite)

        // Percentage change over 15m text
        existsTestTag(composeTestRule, PercentageChange15mTag)
        existsTestTag(composeTestRule, PercentageChange15mLabelTag)
        isDisplayed(composeTestRule, PercentageChange15mTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange15mTag)
        isDisplayed(composeTestRule, PercentageChange15mLabelTag)
        testColors(composeTestRule, PercentageChange15mLabelTag, TextWhite)

        // Percentage change over 30m text
        existsTestTag(composeTestRule, PercentageChange30mTag)
        existsTestTag(composeTestRule, PercentageChange30mLabelTag)
        isDisplayed(composeTestRule, PercentageChange30mTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange30mTag)
        isDisplayed(composeTestRule, PercentageChange30mLabelTag)
        testColors(composeTestRule, PercentageChange30mLabelTag, TextWhite)

        // Percentage change over 1hr text
        existsTestTag(composeTestRule, PercentageChange1hrTag)
        existsTestTag(composeTestRule, PercentageChange1hrLabelTag)
        isDisplayed(composeTestRule, PercentageChange1hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange1hrTag)
        isDisplayed(composeTestRule, PercentageChange1hrLabelTag)
        testColors(composeTestRule, PercentageChange1hrLabelTag, TextWhite)

        // Percentage change over 6hr text
        existsTestTag(composeTestRule, PercentageChange6hrTag)
        existsTestTag(composeTestRule, PercentageChange6hrLabelTag)
        isDisplayed(composeTestRule, PercentageChange6hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange6hrTag)
        isDisplayed(composeTestRule, PercentageChange6hrLabelTag)
        testColors(composeTestRule, PercentageChange6hrLabelTag, TextWhite)

        // Percentage change over 12hr text
        existsTestTag(composeTestRule, PercentageChange12hrTag)
        existsTestTag(composeTestRule, PercentageChange12hrLabelTag)
        isDisplayed(composeTestRule, PercentageChange12hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange12hrTag)
        isDisplayed(composeTestRule, PercentageChange12hrLabelTag)
        testColors(composeTestRule, PercentageChange12hrLabelTag, TextWhite)

        // Percentage change over 24hr text
        existsTestTag(composeTestRule, PercentageChange24hrTag)
        existsTestTag(composeTestRule, PercentageChange24hrLabelTag)
        isDisplayed(composeTestRule, PercentageChange24hrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange24hrTag)
        isDisplayed(composeTestRule, PercentageChange24hrLabelTag)
        testColors(composeTestRule, PercentageChange24hrLabelTag, TextWhite)

        // Percentage change over 7d text
        existsTestTag(composeTestRule, PercentageChange7dTag)
        existsTestTag(composeTestRule, PercentageChange7dLabelTag)
        isDisplayed(composeTestRule, PercentageChange7dTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange7dTag)
        isDisplayed(composeTestRule, PercentageChange7dLabelTag)
        testColors(composeTestRule, PercentageChange7dLabelTag, TextWhite)

        // Percentage change over 30d text
        existsTestTag(composeTestRule, PercentageChange30dTag)
        existsTestTag(composeTestRule, PercentageChange30dLabelTag)
        isDisplayed(composeTestRule, PercentageChange30dTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange30dTag)
        isDisplayed(composeTestRule, PercentageChange30dLabelTag)
        testColors(composeTestRule, PercentageChange30dLabelTag, TextWhite)

        // Percentage change over 1yr text
        existsTestTag(composeTestRule, PercentageChange1yrTag)
        existsTestTag(composeTestRule, PercentageChange1yrLabelTag)
        isDisplayed(composeTestRule, PercentageChange1yrTag)
        test_positive_and_negative_text_colors(composeTestRule, PercentageChange1yrTag)
        isDisplayed(composeTestRule, PercentageChange1yrLabelTag)
        testColors(composeTestRule, PercentageChange1yrLabelTag, TextWhite)

    }

    @Test
    fun test_Price_Card_Functionality(){
        clickButton(composeTestRule, PriceCardTag)
        wait(composeTestRule)
        composeTestRule.onRoot().printToLog("TAG")
        // Todo: assert that price details are not displayed
        isNotDisplayed(composeTestRule, PriceCardTag)
    }

    @Test
    fun test_Description_Card_Visibility(){
        existsTestTag(composeTestRule, DescriptionTitleTag)
        existsTestTag(composeTestRule, DescriptionTag)
        isDisplayed(composeTestRule, DescriptionTitleTag)
        isDisplayed(composeTestRule, DescriptionTag)
        isClickable(composeTestRule, DescriptionTag)
        textIsCorrect(composeTestRule, DescriptionTitleTag, "Description")
        testColors(composeTestRule, DescriptionTitleTag, TextWhite)
        testColors(composeTestRule, DescriptionTag, DarkGray)
    }

    @Test
    fun test_Description_Card_Functionality(){
        clickButton(composeTestRule, DescriptionTag) // expand card
        wait(composeTestRule)
        existsTestTag(composeTestRule, DescriptionTextTag)
        isDisplayed(composeTestRule, DescriptionTextTag) // details
        textIsCorrect(composeTestRule, DescriptionTitleExpandedTag, fakeDetailNameExpanded)
        clickButton(composeTestRule, DescriptionTag) // collapse card
        textIsCorrect(composeTestRule, DescriptionTitleTag, fakeDetailNameCollapsed)
        isNotDisplayed(composeTestRule, DescriptionTextTag)
    }

    @Test
    fun test_Team_Card_Visibility(){
        existsTestTag(composeTestRule, TeamTitleTestTag)
        existsTestTag(composeTestRule, TeamCardTestTag)
        isDisplayed(composeTestRule, TeamTitleTestTag)
        isDisplayed(composeTestRule, TeamCardTestTag)
        isClickable(composeTestRule, TeamCardTestTag)
        textIsCorrect(composeTestRule, TeamTitleTestTag, "Team")
        testColors(composeTestRule, TeamTitleTestTag, TextWhite)
        testColors(composeTestRule, TeamCardTestTag, DarkGray)
    }

    @Test
    fun test_Team_Card_Functionality(){
        clickButton(composeTestRule, TeamCardTestTag) // expand card
        wait(composeTestRule)
        existsTestTag(composeTestRule, TeamDetailsTestTag)
        isDisplayed(composeTestRule, TeamDetailsTestTag) // details
        existsText(composeTestRule, fakeTeamMemberName)
        isTextDisplayed(composeTestRule, fakeTeamMemberName)
        clickButton(composeTestRule, TeamCardTestTag) // collapse card
        isNotDisplayed(composeTestRule, TeamDetailsTestTag)
    }

    @Test
    fun test_Tag_Card_Visibility(){
        scrollToElementWithTag(composeTestRule, TagsCardTag)
        existsTestTag(composeTestRule, TagsTitleTag)
        existsTestTag(composeTestRule, TagsCardTag)
        isDisplayed(composeTestRule, TagsTitleTag)
        isDisplayed(composeTestRule, TagsCardTag)
        isClickable(composeTestRule, TagsCardTag)
        textIsCorrect(composeTestRule, TagsTitleTag, "Tags")
        testColors(composeTestRule, TagsTitleTag, TextWhite)
        testColors(composeTestRule, TagsCardTag, DarkGray)
    }

    @Test
    fun test_Tag_Card_Functionality(){
        scrollToElementWithTag(composeTestRule, TagsCardTag)
        clickButton(composeTestRule, TagsCardTag) // expand card
        wait(composeTestRule)
        existsTestTag(composeTestRule, TagsDetailsTag)
        isDisplayed(composeTestRule, TagsDetailsTag) // details
        clickButton(composeTestRule, TagsCardTag) // collapse card
        isNotDisplayed(composeTestRule, TeamDetailsTestTag)
    }

    @Test
    fun test_Explore_Card_Visibility(){
        scrollToTextElement(composeTestRule, "Explore")
        existsTestTag(composeTestRule, ExploreTitleTag)
        existsTestTag(composeTestRule, ExploreCardTag)
        textIsCorrect(composeTestRule, ExploreTitleTag, "Explore")
        testColors(composeTestRule, ExploreTitleTag, TextWhite)
        isClickable(composeTestRule, ExploreCardTag)
        testColors(composeTestRule, ExploreCardTag, DarkGray)
    }

    @Test
    fun test_Explore_Card_Functionality(){

        scrollToTextElement(composeTestRule, "Explore")
        clickButton(composeTestRule, ExploreCardTag) // expand card
        wait(composeTestRule)

        existsText(composeTestRule, test_link_extended_url)
        scrollToTextElement(composeTestRule, test_link_extended_url)
        isDisplayed(composeTestRule, test_link_extended_url) // details
        clickButton(composeTestRule, ExploreCardTag) // collapse card
        isTextNotDisplayed(composeTestRule, test_link_extended_url)
    }

    @Test
    fun test_Social_Media_Card_Visibility(){
       // scrollToTextElement(composeTestRule, "Social Media")
        existsTestTag(composeTestRule, SocialMediaTitleTag)
        scrollToElementWithTag(composeTestRule, SocialMediaTitleTag)
        textIsCorrect(composeTestRule, SocialMediaTitleTag, "Social Media")
        isDisplayed(composeTestRule, SocialMediaTitleTag)
        testColors(composeTestRule, SocialMediaTitleTag, TextWhite)

        existsTestTag(composeTestRule, SocialMedialCardTag)
        isClickable(composeTestRule, SocialMedialCardTag)
        testColors(composeTestRule, SocialMedialCardTag, DarkGray)
    }

    @Test
    fun test_Social_Media_Card_Functionality(){

        scrollToElementWithTag(composeTestRule, SocialMedialCardTag)
        wait(composeTestRule)
        clickButton(composeTestRule, SocialMedialCardTag) // expand card
        wait(composeTestRule)

        existsText(composeTestRule, test_explorer)
        existsText(composeTestRule, test_facebook)
        existsText(composeTestRule, test_medium)
        existsText(composeTestRule, test_reddit)
        existsText(composeTestRule, test_source_code)
        existsText(composeTestRule, test_website)
        existsText(composeTestRule, test_youtube)

        isTextDisplayed(composeTestRule, test_explorer)
        isTextDisplayed(composeTestRule, test_facebook)
        isTextDisplayed(composeTestRule, test_medium)
        isTextDisplayed(composeTestRule, test_reddit)
        isTextDisplayed(composeTestRule, test_source_code)
        isTextDisplayed(composeTestRule, test_website)
        isTextDisplayed(composeTestRule, test_youtube)

        clickButton(composeTestRule, SocialMedialCardTag) // collapse card

        isTextNotDisplayed(composeTestRule, test_explorer)
        isTextNotDisplayed(composeTestRule, test_facebook)
        isTextNotDisplayed(composeTestRule, test_medium)
        isTextNotDisplayed(composeTestRule, test_reddit)
        isTextNotDisplayed(composeTestRule, test_source_code)
        isTextNotDisplayed(composeTestRule, test_website)
        isTextNotDisplayed(composeTestRule, test_youtube)
    }

    @Test
    fun back_button_visibility(){
        existsTestTag(composeTestRule, BackButtonTestTag)
        scrollToElementWithTag(composeTestRule, BackButtonTestTag)
        isDisplayed(composeTestRule, BackButtonTestTag)
        isClickable(composeTestRule, BackButtonTestTag)
    }

    @Test
    fun back_button_functionality(){
        scrollToElementWithTag(composeTestRule, BackButtonTestTag)
        clickButton(composeTestRule, BackButtonTestTag)
        isDisplayed(composeTestRule, CoinListScreenTag) // is on coin list screen
    }
}