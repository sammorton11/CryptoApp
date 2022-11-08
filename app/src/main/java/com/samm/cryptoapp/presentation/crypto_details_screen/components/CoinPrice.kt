package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samm.cryptoapp.presentation.crypto_details_screen.CoinPriceDetailsState
import com.samm.cryptoapp.presentation.crypto_details_screen.util.Converters.roundOffDecimal

@Composable
fun CoinPrice(state: CoinPriceDetailsState) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(bottom = 25.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth()
    ) {

        // Price
        state.coins?.let { priceData ->
            val price = roundOffDecimal(priceData.quotes.USD.price)
            Column(
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Price (USD):  $$price",
                    modifier = Modifier.padding(15.dp),
                    fontSize = 18.sp,
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Start
                )

                if (expanded) {
                    PercentChange(priceData)
                    // Supply
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                    ) {
                        Text(
                            text = "Max Supply:   ",
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "${priceData.max_supply}",
                            textAlign = TextAlign.Center
                        )
                    }

                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(15.dp)
                    ) {
                        Text(
                            text = "Total Supply:  ",
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "${priceData.total_supply}",
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

