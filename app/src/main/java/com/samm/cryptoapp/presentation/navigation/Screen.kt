package com.samm.cryptoapp.presentation.navigation

sealed class Screen(val route: String) {
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
    object WebViewScreen: Screen("web_view_screen")
}