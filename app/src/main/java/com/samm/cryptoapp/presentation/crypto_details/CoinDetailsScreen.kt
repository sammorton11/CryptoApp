package com.samm.cryptoapp.presentation.crypto_details

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.accompanist.flowlayout.FlowRow
import com.samm.cryptoapp.presentation.viewmodel.CoinDetailViewModel
import com.samm.cryptoapp.presentation.viewmodel.CoinPriceDetailViewModel
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.roundToInt

@Composable
fun CoinDetailsScreen(
    viewModelPrice: CoinPriceDetailViewModel = hiltViewModel(),
    viewModelInfo: CoinDetailViewModel = hiltViewModel(),
    navController: NavController,
) {
    val priceDetailsState = viewModelPrice.state.value // state from the viewModel
    val detailsState = viewModelInfo.state.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
                .verticalScroll(ScrollState(15))
        ) {


            detailsState.coins?.let {

                if (it.logo?.isNotBlank() == true){
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        AsyncImage(
                            model = "${it.logo}",
                            modifier = Modifier
                                .width(200.dp)
                                .height(200.dp),
                            contentDescription = "",
                            alignment = Alignment.TopCenter,
                            contentScale = ContentScale.FillWidth,
                            filterQuality = FilterQuality.High
                        )
                    }
                }
                //Description Text
                Text(
                    text = "Description:",
                    modifier = Modifier.padding(bottom = 15.dp),
                    fontSize = 18.sp
                )
                Text(text = it.description)

                Spacer(modifier = Modifier.padding(10.dp))

                //Price Data
                priceDetailsState.coins?.let { priceData ->
                    val price = roundOffDecimal(priceData.quotes.USD.price)
                    Text(text = "Price (USD): $$price per/coin")
                }

                Spacer(modifier = Modifier.padding(10.dp))

                // Row of Tags
                Text(
                    text = "Tags:",
                    modifier = Modifier.padding(bottom = 15.dp),
                    fontSize = 18.sp
                )
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    it.tags.forEach { tag ->
                        Text(text = "$tag")
                    }
                }

            }
        }
        if(detailsState.error.isNotBlank() || priceDetailsState.error.isNotBlank()) {
            Text(
                text = detailsState.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if(detailsState.isLoading || priceDetailsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }


    }
}


// Todo: Move this somewhere else
fun roundOffDecimal(number: Double): Double? {
    val df = DecimalFormat("#.##")
    df.roundingMode = RoundingMode.CEILING
    return df.format(number).toDouble()
}



