package com.samm.cryptoapp.presentation.crypto_list_screen.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel

@Composable
fun CoinListTopBar(
    navController: NavController,
    viewModel: CoinListViewModel,
    context: Context
){
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                contentDescription = "Top Bar"
                testTag = "Top Bar Test Tag"
            },
        backgroundColor = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Title()
            RefreshButton(viewModel, context)
        }
    }
}