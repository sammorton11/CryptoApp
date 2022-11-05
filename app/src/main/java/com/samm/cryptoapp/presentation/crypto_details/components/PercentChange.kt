package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.data.remote.dto.price_details.CoinPriceDetailsDtoItem
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData
import com.samm.cryptoapp.presentation.crypto_details.CoinPriceDetailsState

@Composable
fun PercentChange(data: CoinPriceDetailsData) {

    val change15m = data.quotes.USD.percent_change_15m
    val change30m = data.quotes.USD.percent_change_30m
    val change60m = data.quotes.USD.percent_change_1h

    Column(
        Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
    ) {
        Row() {
            Text(
                text = "15m:     "
            )
            Text(
                text = "${change15m}%",
                color = if(change15m > 0) Color.Green else Color.Red
            )
        }

        Row() {
            Text(
                text = "30m:     "
            )
            Text(
                text = "${change30m}%",
                color = if(change30m > 0) Color.Green else Color.Red
            )
        }

        Row() {
            Text(
                text = "1hr:       "
            )
            Text(
                text = "${change60m}%",
                color = if(change60m > 0) Color.Green else Color.Red
            )
        }

    }
}