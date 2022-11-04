package com.samm.cryptoapp.presentation.crypto_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CoinTopBar() {

    var searchTerm by remember { mutableStateOf("") }

    // todo: Goes in Components package as a comp
    TopAppBar(
        modifier = Modifier.height(85.dp),
        backgroundColor = Color.Transparent
    ) {

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(9.dp)
        ) {
            TextField(
                value = searchTerm,
                onValueChange = { searchTerm = it }
            )
        }
    }
}