package com.samm.cryptoapp.presentation.crypto_list_screen

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
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

    Box(modifier = Modifier
        .fillMaxSize()
        .semantics {
            testTag = "Coin List Screen Tag"
        }
    ) {
        Column {

            CoinListTopBar(navController, viewModel, context)
            // List of Coins
            CoinList(
                navController = navController, 
                context = context,
                viewModel = viewModel
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
                        testTag = "Error Tag" },
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

