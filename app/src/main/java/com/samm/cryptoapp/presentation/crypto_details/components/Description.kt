package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.presentation.crypto_details.CoinPriceDetailsState

@Composable
fun Description(data: CoinDetailsData, priceState: CoinPriceDetailsState) {
    //Description Text
    Text(
        text = "Description:",
        modifier = Modifier.padding(bottom = 15.dp),
        fontSize = 18.sp,
        color = Color.Cyan
    )
    Text(text = data.description)
    CoinPrice(priceState)
}