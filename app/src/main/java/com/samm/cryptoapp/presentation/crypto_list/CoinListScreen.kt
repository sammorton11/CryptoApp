package com.samm.cryptoapp.presentation.crypto_list

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.crypto_list.components.*
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel


@Composable
fun CoinListScreen(
    navController: NavController,
    context: Context,
    viewModel: CoinListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value // state from the viewModel
    var searchTerm by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {

        Column {
            CoinListTopBar(navController)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(21.dp)
            ) {
                // Search Field
                OutlinedTextField(
                    value = searchTerm,
                    onValueChange = {searchTerm = it},
                    modifier = Modifier.padding(start = 15.dp),
                    enabled = true,
                    label = {
                        Text(
                            "Search Coins",
                            color = Color.White,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                )
            }
            
            CoinList(
                state = state, 
                searchTerm = searchTerm, 
                navController = navController, 
                context = context
            )
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

