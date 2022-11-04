package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.presentation.crypto_details.CoinPriceDetailsState
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun CoinPrice(state: CoinPriceDetailsState) {
    Column(Modifier
        .fillMaxWidth()
        .padding(top = 20.dp)) {

        // Price
        state.coins?.let { priceData ->
            val price = roundOffDecimal(priceData.quotes.USD.price)
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(
                    text = "Price (USD):  ",
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "$$price",
                    textAlign = TextAlign.Center
                )
            }

            // Supply
            Row(Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)) {
                Text(
                    text = "Max Supply:  ",
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${priceData.max_supply} coins",
                    textAlign = TextAlign.Center
                )
            }

            Row(Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)) {
                Text(
                    text = "Total Supply:  ",
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${priceData.total_supply} coins",
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

fun roundOffDecimal(number: Double): Double {
    val df = DecimalFormat("#.####")
    df.roundingMode = RoundingMode.CEILING
    return df.format(number).toDouble()
}