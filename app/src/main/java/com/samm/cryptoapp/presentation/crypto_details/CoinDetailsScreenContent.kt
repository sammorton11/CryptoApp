package com.samm.cryptoapp.presentation.crypto_details

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.presentation.crypto_details.components.*

@Composable
fun CoinDetailsScreenContent(
    detailsState: CoinDetailsState,
    priceDetailsState: CoinPriceDetailsState,
    context: Context
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        if(detailsState.error.isNotBlank() && priceDetailsState.error.isNotBlank()) {
            ErrorText(detailsState)
        }
        if(detailsState.isLoading || priceDetailsState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        } else {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 25.dp)
                    .verticalScroll(ScrollState(15))
            ) {

                detailsState.coins?.let { coinData ->

                    val website = coinData.links?.website
                    val site = coinData.linksExtended[0]?.url
                    Logo(coinData)
                    CoinPrice(priceDetailsState)
                    Description(coinData)
                    if (site != null) {
                        WebsiteButton(site, context)
                    }
                    Team(coinData)
                    Tags(coinData)
                    ExploreLinks(coinData, context)
                    Spacer(modifier = Modifier
                        .padding(top = 25.dp, bottom = 25.dp)
                    )
                    SocialMediaLinks(coinData, context)
                }
            }
        }
    }
}

fun openWebsite(website: String, context: Context){
    val urlIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse(website)
    )
    context.startActivity(urlIntent)
}