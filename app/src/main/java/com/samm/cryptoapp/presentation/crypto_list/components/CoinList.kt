package com.samm.cryptoapp.presentation.crypto_list.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.Screen
import com.samm.cryptoapp.presentation.crypto_list.CoinsListState

@Composable
fun CoinList(state: CoinsListState, searchTerm: String, navController: NavController) {

    // Todo: Redo this -- DRY
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        val coinData = state.coins
        val coinDataFiltered = state.coins.filter { it.name.contains(searchTerm) }


        if (searchTerm.isNotBlank()){
            // filtered
            items(coinDataFiltered) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                    }
                )
            }
        } else {
            // using the List of Coin Data as the items
            items(coinData) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                    }
                )
            }
        }
    }
}