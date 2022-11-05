package com.samm.cryptoapp.presentation.crypto_details.components

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.presentation.crypto_details.openWebsite

@Composable
fun WebsiteButton(websiteLink: String, context: Context) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(25.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(onClick = { openWebsite(websiteLink, context) }) {
            Text(text = "Open Website")
        }
    }
}