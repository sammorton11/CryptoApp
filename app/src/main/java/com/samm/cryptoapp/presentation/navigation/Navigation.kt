package com.samm.cryptoapp.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.samm.cryptoapp.presentation.crypto_details_screen.CoinDetailsScreen
import com.samm.cryptoapp.presentation.crypto_list_screen.CoinListScreen
import com.samm.cryptoapp.presentation.web_view_screen.WebViewScreen

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
            CoinListScreen(navController, context)
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ){
            CoinDetailsScreen(navController = navController)
        }
        composable(
            route = "${Screen.WebViewScreen.route}/{mUrl}",
            listOf(navArgument("mUrl"){ type = NavType.StringType })) { navBack ->
            navBack.arguments?.getString("mUrl").let { mUrl ->
                if (mUrl != null) WebViewScreen(mUrl)
            }
        }
    }
}