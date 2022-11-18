package com.samm.cryptoapp

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.fakes_test_shared.FakeDataSource.FakeData.fakeCoinName01
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinCardTestTag
import com.samm.cryptoapp.fakes_test_shared.TestTags.CoinDetailsScreenTag
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
                        Navigation(context = this)
                    }
                }
            }
        }
    }

    @Test
    fun test_search_field(){
        testVisibilityContentDescription(composeTestRule, "Search Field")
        testVisibilityTestTag(composeTestRule, "Search Field Label Tag")
        testColors(composeTestRule, "Search Field Label Tag", TextWhite)
        /*
            todo:
             - test more - size, style, color, text
             - Coin Name is not displaying correctly -- Displaying a number instead of name
         */
    }

    @Test
    fun click_coin_list_item(){
        isClickable(composeTestRule, CoinCardTestTag)
        clickButton(composeTestRule, CoinCardTestTag)
        isDisplayed(composeTestRule, CoinDetailsScreenTag) // check if details screen is displayed
    }

    @Test
    fun checkUI(){
        composeTestRule.waitForIdle()
        Thread.sleep(5000)
    }

    @Test
    fun test_coin_name(){
        composeTestRule.waitForIdle()
        composeTestRule.onNodeWithText(fakeCoinName01).assertTextEquals(values = arrayOf(fakeCoinName01), includeEditableText = false)
    }
}