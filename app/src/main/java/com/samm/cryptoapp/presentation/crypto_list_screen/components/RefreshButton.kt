package com.samm.cryptoapp.presentation.crypto_list_screen.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.navigation.Screen

@Composable
fun RefreshButton(navController: NavController) {
    // Refresh Button
    IconButton(
        onClick = { navController.navigate(Screen.CoinListScreen.route) },

    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh Button"
        )
    }
}