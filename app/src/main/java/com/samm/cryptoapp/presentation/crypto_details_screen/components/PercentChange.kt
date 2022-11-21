package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import com.samm.cryptoapp.domain.model.CoinPriceDetailsData


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
        Column {

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "15m: ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 15m label"
                        },
                )
                Text(
                    text = "${change15m}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 15m"
                        },
                    color = if(change15m > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "30m: ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 30m label"
                        },
                )
                Text(
                    text = "${change30m}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 30m"
                        },
                    color = if(change30m > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                // Hour
                Text(
                    text = "1hr:   ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 1hr label"
                        },
                )
                Text(
                    text = "${change60m}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 1hr"
                        },
                    color = if(change60m > 0) Color.Green else Color.Red
                )
            }

        }

        // Column 2
        Column {
            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "6hr:   ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 6hr label"
                        },
                )
                Text(
                    text = "${change6hr}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 6hr"
                        },
                    color = if(change6hr > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "12hr: ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 12hr label"
                        }
                )
                Text(
                    text = "${change12hr}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 12hr"
                        },
                    color = if(change12hr > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "24hr: ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 24hr label"
                        },
                )
                Text(
                    text = "${change24hr}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 24hr"
                        },
                    color = if(change24hr > 0) Color.Green else Color.Red
                )
            }

        }

        // Column 3
        Column {

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "7d:   ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 7d label"
                        },
                )
                Text(
                    text = "${change7d}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 7d"
                        },
                    color = if(change7d > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Text(
                    text = "30d: ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 30d label"
                        },
                )
                Text(
                    text = "${change30d}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 30d"
                        },
                    color = if(change30d > 0) Color.Green else Color.Red
                )
            }

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                // Year
                Text(
                    text = "1yr:   ",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 1yr label"
                        },
                )
                Text(
                    text = "${change1y}%",
                    modifier = Modifier
                        .semantics {
                            testTag = "Percentage Change 1yr"
                        },
                    color = if(change1y > 0) Color.Green else Color.Red
                )
            }
        }
    }
}