package com.samm.cryptoapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.assertEquals


abstract class BaseTest {

    fun testVisibility(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        composeTestRule.onNodeWithTag(tag, true).assertExists()
        composeTestRule.onNodeWithTag(tag, true).assertIsDisplayed()
    }

    fun testColors(
        composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        testTag: String,
        expectedBackground: Color,
    ){
        val capturedName = composeTestRule
            .onNodeWithTag(testTag, true)
            .captureToImage().colorSpace.name

        assertEquals(expectedBackground.colorSpace.name, capturedName)
    }

    fun clickButton(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        rule.onNodeWithTag(tag, true).performClick()
    }

    fun typeInText(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        rule.onNodeWithTag(tag, true).performTextInput("Bitcoin")
    }

    fun isClickable(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        rule.onNodeWithTag(tag, true).assertHasClickAction()
    }

    fun isDisplayed(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        rule.onNodeWithTag(tag, true).assertIsDisplayed()
    }

    fun isNotDisplayed(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        rule.onNodeWithTag(tag, true).assertIsNotDisplayed()
    }

    fun isTextDisplayed(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        name: String,
    ){
        rule.onNodeWithText(name).assertIsDisplayed()
    }

    fun textIsCorrect(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
        expected: String,
    ){
        rule.onNodeWithTag(tag, true).assertTextEquals(expected)
    }

    fun scrollToElement(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        name: String,
    ){
        rule.onNodeWithText(name).assertExists()
        rule.onNodeWithText(name).performScrollTo()
    }

    fun test_positive_and_negative_text_colors(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        tag: String,
    ){
        rule.onNodeWithTag(tag, true)
    }

    fun test_positive_and_negative_text_colors(
        rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
        testTag: String,
        text: String
    ){
        if (text.toInt() > 0){
            testColors(rule, testTag, Color.Green)
        }
        else {
            testColors(rule, testTag, Color.Red)
        }
    }
}