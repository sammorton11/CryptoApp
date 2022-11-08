package com.samm.cryptoapp.presentation.crypto_list_screen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.domain.model.CoinData

@Composable
fun SearchResultsLabel(coinData: List<CoinData>, searchTerm: String) {
    if (searchTerm.isNotBlank()){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Text(text = "Results for '${searchTerm}' :  ${coinData.size}")
        }
    }
}