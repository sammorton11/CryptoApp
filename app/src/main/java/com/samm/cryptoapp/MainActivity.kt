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
   Todo (Issues in-progress):
        - I some of my end-to-end tests are actually integration tests?
        - How to test network error?
        - Organizing tests into separated inner classes throws errors
        - Test links not showing up in semantics tree and are failing isDisplayed tests but are verified
        - to be displayed when manual testing - passing 'exists' tests - weird
        - isNotDisplayed() tests still fail after collapsing card and text is not displayed - confused

        Todo:
         - Issue sharing fakes/test-doubles between androidTest and test packages
         - Data models from production code are used in fakes, so when using a separate library module
         - containing the fake data and then importing that library module to share between packages,
         - the separate library module can't see that production code data models. ugh lol.
         - Need to figure out how to test the progress bar
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