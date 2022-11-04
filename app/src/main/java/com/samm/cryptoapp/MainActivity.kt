package com.samm.cryptoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samm.cryptoapp.presentation.Screen
import com.samm.cryptoapp.presentation.crypto_details.CoinDetailsScreen
import com.samm.cryptoapp.presentation.crypto_list.CoinListScreen
import com.samm.cryptoapp.presentation.crypto_list.MainScreen
import com.samm.cryptoapp.presentation.ui.theme.CryptoAppTheme
import dagger.hilt.android.AndroidEntryPoint

/*
    Todo:
     - Search field in top bar
     - Search for a coin within results list
     - When Search Icon button is pressed - filter search list with that string
     - When done with UI - start tests - unit, integration, end-to-end
     - ADD TO GITHUB
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
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }

                        // Todo: Composable for Details Screen
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}"){
                            CoinDetailsScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoAppTheme {
        Greeting("Android")
    }
}