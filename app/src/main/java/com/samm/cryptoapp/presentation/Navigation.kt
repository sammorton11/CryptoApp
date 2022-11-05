package com.samm.cryptoapp.presentation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.samm.cryptoapp.presentation.crypto_details.CoinDetailsScreen
import com.samm.cryptoapp.presentation.crypto_list.CoinListScreen

@Composable
fun Navigation(context: Context) {
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
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ){
            CoinDetailsScreen(navController = navController, context = context)
        }
    }
}