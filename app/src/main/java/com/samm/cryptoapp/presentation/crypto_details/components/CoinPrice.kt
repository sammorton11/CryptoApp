package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.samm.cryptoapp.presentation.crypto_details.CoinPriceDetailsState
import com.samm.cryptoapp.presentation.crypto_details.util.Converters
import com.samm.cryptoapp.presentation.crypto_details.util.Converters.roundOffDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

@Composable
fun CoinPrice(state: CoinPriceDetailsState) {

    Column(Modifier
        .fillMaxWidth()
        .padding(top = 25.dp, bottom = 30.dp)
        .border(
            width = 1.dp,
            color = MaterialTheme.colors.primary,
        )
    ){

        // Price
        state.coins?.let { priceData ->
            val price = roundOffDecimal(priceData.quotes.USD.price)

            Column(Modifier.padding(10.dp)) {

                Row(
                    Modifier.fillMaxWidth()
                ){
                    Text(
                        text = "Price (USD):  ",
                        modifier = Modifier.padding(bottom = 8.dp),
                        fontSize = 18.sp,
                        color = Color.Cyan,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "$$price",
                        textAlign = TextAlign.Center
                    )
                }
            }



            PercentChange(priceData)

            // Supply
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp)
            ){
                Text(
                    text = "Max Supply:   ",
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${priceData.max_supply} coins",
                    textAlign = TextAlign.Center
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, bottom = 10.dp)
            ) {
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
