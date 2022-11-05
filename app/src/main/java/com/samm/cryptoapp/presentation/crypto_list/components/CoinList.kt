package com.samm.cryptoapp.presentation.crypto_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samm.cryptoapp.common.Constants.LIST_AMOUNT
import com.samm.cryptoapp.domain.model.CoinData
import com.samm.cryptoapp.presentation.Screen
import com.samm.cryptoapp.presentation.crypto_list.CoinsListState

@Composable
fun CoinList(state: CoinsListState, searchTerm: String, navController: NavController) {

    // Data filtered by a search term provided in the text field
    val coinData = if (searchTerm.isNotBlank()) {
        state.coins.filter { it.name.contains(searchTerm.capitalize()) }
    } else {
        state.coins
    }

    // Filtering the active coins only -- inActive coins are usually empty and useless ->
    // - may change this
    //val coinData = coinDataFilteredBySearchTerm.filter { it.is_active }

   Column {
       SearchResultsLabel(coinData, searchTerm)
       LazyColumn(modifier = Modifier.fillMaxSize()) {
           // Sorting the data list by Rank in terms of market value
           // When user searched a coin, the data list will still remain in that order
           // Using the take function to only use 10000 coins -- there are 45k types of coin
           // and it takes up too much memory.
           // Todo: Add comps to be able to trigger how many coins are displayed
           items(coinData.take(LIST_AMOUNT).sortedBy { it.rank }) { coin ->
               if (coin.rank > 0){
                   CoinListItem(
                       coin = coin,
                       onItemClick = {
                           // Only open the details screen if coin is active
                           if (coin.is_active){
                               navController.navigate(
                                   Screen.CoinDetailScreen.route + "/${coin.id}"
                               )
                           }
                       }
                   )
               }

           }
       }
   }
}
