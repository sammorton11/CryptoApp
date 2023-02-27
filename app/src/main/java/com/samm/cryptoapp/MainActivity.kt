package com.samm.cryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.samm.cryptoapp.presentation.navigation.Navigation
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

/*
   (Issues - in-progress):
        - -- I think some of my end-to-end tests are actually integration tests? --
        - -- Test explore and social media links not showing up in semantics tree and are failing isDisplayed tests but are verified
        -    to be displayed when manual testing - they pass assertExists though - weird --
        - -- isNotDisplayed() tests still fail after collapsing card and text is not displayed - confused

        Todo:
         - Test progress bar
         - Test Network Error
         - Replace test tags with string resources
         - Finish integration tests

 */

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Navigation(context = this)
                }
            }
        }
    }
}