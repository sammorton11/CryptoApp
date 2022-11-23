package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.ui.theme.TextWhite

@Composable
fun BackButton(navController: NavController) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ){
        OutlinedButton(
            onClick = { navController.popBackStack() },
            modifier = Modifier
                .width(155.dp)
                .semantics {
                    contentDescription = "Back Button"
                    testTag = "Back Button Test Tag"
                }
        ) {
            Text(text = "Back", color = TextWhite)
        }
    }
}