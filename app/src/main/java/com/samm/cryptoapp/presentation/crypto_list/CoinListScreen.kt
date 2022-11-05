package com.samm.cryptoapp.presentation.crypto_list

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.crypto_list.components.CoinList
import com.samm.cryptoapp.presentation.crypto_list.components.RefreshButton
import com.samm.cryptoapp.presentation.crypto_list.components.ResultsTextLabel
import com.samm.cryptoapp.presentation.crypto_list.components.Title
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel


@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value // state from the viewModel
    val resultsAmount = state.coins.size.toString()
    var searchTerm by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.Transparent
            ) {
               Row(
                   modifier = Modifier.fillMaxWidth(),
                   horizontalArrangement = Arrangement.Center,
                   verticalAlignment = Alignment.CenterVertically
               ) {
                   Title(navController)
                   RefreshButton(navController)
               }

            }

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(9.dp)
            ) {
                // Search Field
                TextField(
                    value = searchTerm,
                    onValueChange = { searchTerm = it }
                )
            }
            ResultsTextLabel(resultsAmount)
            CoinList(state, searchTerm, navController)
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

