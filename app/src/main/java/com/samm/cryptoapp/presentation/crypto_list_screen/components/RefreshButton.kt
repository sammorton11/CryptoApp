package com.samm.cryptoapp.presentation.crypto_list_screen.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.navigation.Screen

@Composable
fun RefreshButton(navController: NavController) {
    // Refresh Button
    IconButton(
        onClick = { navController.navigate(Screen.CoinListScreen.route) },
        modifier = Modifier
            .semantics {
                contentDescription = "Refresh Button"
                testTag = "Refresh Button Test Tag"
            },

    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh Icon"
        )
    }
}