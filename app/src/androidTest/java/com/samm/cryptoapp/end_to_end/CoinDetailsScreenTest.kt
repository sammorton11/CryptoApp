package com.samm.cryptoapp.end_to_end

import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.samm.cryptoapp.MainActivity
import com.samm.cryptoapp.di.AppModule
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import com.samm.cryptoapp.util.BaseTest
import com.samm.cryptoapp.util.TestContext.appContext
import com.samm.cryptoapp.util.fakes.TestTags.CoinListItemTags.CoinCardTestTag
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule

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
}