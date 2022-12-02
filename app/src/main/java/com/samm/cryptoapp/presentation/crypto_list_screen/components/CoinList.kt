package com.samm.cryptoapp.presentation.crypto_list_screen.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.samm.cryptoapp.common.Constants.LIST_AMOUNT
import com.samm.cryptoapp.presentation.navigation.Screen
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel

@Composable
fun CoinList(navController: NavController, context: Context, viewModel: CoinListViewModel) {

    val coinData = viewModel.state.value.coins
    Column {
       // SearchResultsLabel(coinData, searchTerm)

       LazyColumn(modifier = Modifier.fillMaxSize()) {
           // When user searched a coin, the data list will still remain in that order
           // Using the take function to only use a certain amount of coins -
           // there are 45k types of coin and sometimes uses too much memory.
           items(coinData.take(LIST_AMOUNT)) { coin ->
               CoinListItem(
                   coin = coin,
                   onItemClick = {
                       // Only open the details screen if coin is active
                       if (coin.is_active){
                           navController.navigate(
                               Screen.CoinDetailScreen.route + "/${coin.id}"
                           )
                       } else {
                           Toast.makeText(
                               context,
                               "Denied - Coin is inactive",
                               Toast.LENGTH_SHORT
                           ).show()
                       }
                   }
               )
           }
       }
    }
}
