package com.samm.cryptoapp

import android.graphics.Color
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.test.ext.junit.rules.ActivityScenarioRule

abstract class BaseTest {

    fun testVisibility(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        label: String
    ){
        composeTestRule.onNodeWithContentDescription(label).assertExists()
        composeTestRule.onNodeWithContentDescription(label).assertIsDisplayed()
    }

    // in progress
    fun testColors(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        label: String,
        expectedBackground: Color
    ){
//        val capturedName = captureToImage().colorSpace.name
//        assertEquals(expectedBackground.colorSpace.name, capturedName)
//        composeTestRule.onNodeWithContentDescription(label).assertBackgroundColor()
    }
}