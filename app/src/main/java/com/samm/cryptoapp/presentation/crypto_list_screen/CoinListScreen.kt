package com.samm.cryptoapp.presentation.crypto_list_screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.crypto_list_screen.components.CoinList
import com.samm.cryptoapp.presentation.crypto_list_screen.components.CoinListTopBar
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    context: Context,
    viewModel: CoinListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value // state from the viewModel
    var searchTerm by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .semantics {
            testTag = "Coin List Screen Tag"
        }
    ) {
        Column {

            CoinListTopBar(navController)

            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {

                // Search Field
                OutlinedTextField(
                    value = searchTerm,
                    onValueChange = { searchTerm = it },
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                        .semantics {
                            contentDescription = "Search Field"
                            testTag = "Search Field Tag"
                        },
                    enabled = true,
                    label = {
                        Text(
                            "Search Coins",
                            modifier = Modifier.semantics {
                                    contentDescription = "Search Field Label"
                                    testTag = "Search Field Label Tag"
                            },
                            color = MaterialTheme.colors.onBackground,
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontStyle = FontStyle.Italic
                            )
                        )
                    }
                )
            }

            // List of Coins
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
                    .semantics {
                        contentDescription = "Error Text"
                        testTag = "Error Tag"},
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier
                .align(Alignment.Center)
                .semantics {
                    contentDescription = "Progress Bar"
                    testTag = "Progress Bar Tag"
                })
        }
    }
}

