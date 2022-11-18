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
    Todo(Tests):
     - Fake data is not populating correctly in tests - Test doubles may be setup incorrectly
     - may need to imitate the retrofit call with fake json data or something

     Todo(Tests):
      - LightMode not triggering
      - Test doubles can't be shared - creating separate modules ended in a new issue
      - Test doubles use data modals and DTO's from production code - might not be best practice
      - Having to use repeated code for the test doubles until I find a solution.
      - Trouble understanding setup for API integration tests
      - Extract String Resources - including test tags and content descriptions
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
