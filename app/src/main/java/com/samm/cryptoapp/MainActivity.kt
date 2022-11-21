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

     (Test Issues):
      - Test doubles can't be shared - creating separate modules ended in a new issue
      - The test doubles use data modals and DTO's from production code which can't be seen by
        the tests.

      - Having to use repeated code for the test doubles until I find a solution.
      - Trouble understanding setup for API integration tests
      - Extract String Resources - including test tags and content descriptions
 */

/*
   Todo:
        - Add tags to Team, Explore, and Social Media card components
        - UI tests for the three cards
        - Create a fake Logo for tests
        - Figure out why cards do not expand when clicked in tests
        - Make sure to cover everything for unit tests
        - Integration tests
        - Create a separate module for test doubles and fakes - share between modules
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