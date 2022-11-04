package com.samm.cryptoapp.presentation.crypto_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.Screen
import com.samm.cryptoapp.presentation.crypto_list.components.CoinListItem
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value // state from the viewModel
    val resultsAmount = state.coins.size.toString()
    


    Box(modifier = Modifier.fillMaxSize()) {

        Column {


            TopAppBar(
                elevation = 25.dp,
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    text = "Crypto App",
                    modifier = Modifier.padding(5.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Text(text = "Results: $resultsAmount")
            }
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                // using the List of Coin Data as the items
                items(state.coins) { coin ->

                    CoinListItem(
                        coin = coin,
                        onItemClick = {
                            navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                        }
                    )

                }
            }
        }

        if(state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}