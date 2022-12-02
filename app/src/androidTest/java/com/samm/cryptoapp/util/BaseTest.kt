package com.samm.cryptoapp.util

import android.app.Activity
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.ComposeTestRule
import org.junit.Assert.assertEquals


abstract class BaseTest {

    protected fun testColors(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity,
        expectedBackground: Color,
    ){
        val capturedName = rule
            .onNodeWithTag(activity.getString(resId), true)
            .captureToImage().colorSpace.name

        assertEquals(expectedBackground.colorSpace.name, capturedName)
    }

    protected fun clickButton(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(activity.getString(resId), true).performClick()
    }

    protected fun typeInText(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity,
        text: String
    ){
        rule.onNodeWithTag(
            activity.getString(resId), true
        ).performTextInput(text)
    }

    protected fun isClickable(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(activity.getString(resId), true).assertHasClickAction()
    }

    protected fun existsTestTag(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(activity.getString(resId), true).assertExists()
    }

    protected fun doesNotExistTestTag(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(activity.getString(resId), true).assertDoesNotExist()
    }

    protected fun existsText(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithText(activity.getString(resId), true).assertExists()
    }

    protected fun doesNotExistText(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithText(activity.getString(resId)).assertDoesNotExist()
    }

    protected fun isDisplayed(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(
            activity.getString(resId), true
        ).assertIsDisplayed()
    }

    protected fun isNotDisplayed(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(activity.getString(resId), true).assertIsNotDisplayed()
    }

    protected fun isTextDisplayed(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithText(activity.getString(resId)).assertIsDisplayed()
    }

    protected fun isTextNotDisplayed(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithText(activity.getString(resId)).assertIsNotDisplayed()
    }

    protected fun textIsCorrect(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity,
        expected: String,
    ){
        rule.onNodeWithTag(
            activity.getString(resId), true
        ).assertTextEquals(expected)
    }

    protected fun scrollToTextElement(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ) {
        rule.onNodeWithText(activity.getString(resId)).performScrollTo()

    }
    protected fun scrollToElementWithTag(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        rule.onNodeWithTag(activity.getString(resId), true).performScrollTo()
    }

    protected fun test_positive_and_negative_text_colors(
        rule: ComposeTestRule,
        @StringRes resId: Int,
        activity: Activity
    ){
        if (activity.getString(resId).toInt() > 0){
            testColors(rule, resId, activity, Color.Green)
        }
        else {
            testColors(rule, resId, activity, Color.Red)
        }
    }

    protected fun wait(rule: ComposeTestRule){
        rule.waitForIdle()
        rule.onRoot(useUnmergedTree = false).printToLog("TAG")
    }
}