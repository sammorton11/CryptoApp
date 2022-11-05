package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.samm.cryptoapp.domain.model.CoinDetailsData

@Composable
fun Tags(data: CoinDetailsData) {
    // Team
    Text(
        text = "Tags:",
        modifier = Modifier.padding(bottom = 15.dp),
        fontSize = 18.sp,
        color = Color.Cyan
    )
    FlowRow(
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
    ) {
        data.tags.forEach { tag ->
            Text(text = "${tag?.name}  ")
        }
    }
}