package com.samm.cryptoapp.presentation.crypto_list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// This doesn't work
@Composable
fun SearchField(searchTerm: String) {
// Search Field
    var string = searchTerm
    OutlinedTextField(
        value = searchTerm,
        onValueChange = {string = it},
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