package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.samm.cryptoapp.domain.model.CoinDetailsData

@Composable
fun Logo(data: CoinDetailsData) {

    if (data.logo?.isNotBlank() == true){
        Column(
            modifier = Modifier
                .padding(bottom = 25.dp)
                .fillMaxWidth()
                .padding(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = "${data.logo}",
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .semantics {
                        testTag = "Company Logo Tag"
                    },
                contentDescription = "Company Logo",
                alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth,
                filterQuality = FilterQuality.High
            )
        }
    }
}