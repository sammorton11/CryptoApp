package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData

/*
    Todo: Align the rows and columns -- 3 columns 3 rows in a single parent row -- idea
 */

@Composable
fun PercentChange(data: CoinPriceDetailsData) {

    val change15m = data.quotes.USD.percent_change_15m
    val change30m = data.quotes.USD.percent_change_30m
    val change60m = data.quotes.USD.percent_change_1h

    val change6hr = data.quotes.USD.percent_change_6h
    val change12hr = data.quotes.USD.percent_change_12h
    val change24hr = data.quotes.USD.percent_change_24h

    val change7d = data.quotes.USD.percent_change_7d
    val change30d = data.quotes.USD.percent_change_30d
    val change1y = data.quotes.USD.percent_change_1y



    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        // Column 1
        Column() {

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(text = "15m: ")
                Text(
                    text = "${change15m}%",
                    color = if(change15m > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(text = "30m: ")
                Text(
                    text = "${change30m}%",
                    color = if(change30m > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                // Hour
                Text(
                    text = "1hr:   "
                )
                Text(
                    text = "${change60m}%",
                    color = if(change60m > 0) Color.Green else Color.Red
                )
            }

        }

        // Column 2
        Column(Modifier.clickable {  }) {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "6hr:   "
                )
                Text(
                    text = "${change6hr}%",
                    color = if(change6hr > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "12hr: "
                )
                Text(
                    text = "${change12hr}%",
                    color = if(change12hr > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "24hr: "
                )
                Text(
                    text = "${change24hr}%",
                    color = if(change24hr > 0) Color.Green else Color.Red
                )
            }

        }

        // Column 3
        Column(Modifier.clickable {  }) {

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "7d:   "
                )
                Text(
                    text = "${change7d}%",
                    color = if(change7d > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "30d: "
                )
                Text(
                    text = "${change30d}%",
                    color = if(change30d > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                // Year
                Text(
                    text = "1y:   "
                )
                Text(
                    text = "${change1y}%",
                    color = if(change1y > 0) Color.Green else Color.Red
                )
            }

        }
    }

}