package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.samm.cryptoapp.domain.model.CoinDetailsData

@Composable
fun Logo(data: CoinDetailsData) {

    if (data.logo?.isNotBlank() == true){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "${data.logo}",
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
}