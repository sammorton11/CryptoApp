package com.samm.cryptoapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.assertEquals

abstract class BaseTest {

    fun testVisibilityContentDescription(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        label: String
    ){
        composeTestRule.onNodeWithContentDescription(label).assertExists()
        composeTestRule.onNodeWithContentDescription(label).assertIsDisplayed()
    }

    fun testVisibilityTestTag(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String
    ){
        composeTestRule.onNodeWithTag(tag, true).assertExists()
        composeTestRule.onNodeWithTag(tag, true).assertIsDisplayed()
    }

    fun testColors(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        testTag: String,
        expectedBackground: Color
    ){
        val capturedName = composeTestRule
            .onNodeWithTag(testTag, true)
            .captureToImage().colorSpace.name

        assertEquals(expectedBackground.colorSpace.name, capturedName)
    }

    fun clickButton(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String
    ){
        rule.onNodeWithTag(tag, true).performClick()
    }

    fun isClickable(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String
    ){
        rule.onNodeWithTag(tag, true).assertHasClickAction()
    }

    fun isDisplayed(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String
    ){
        rule.onNodeWithTag(tag).assertIsDisplayed()
    }
}