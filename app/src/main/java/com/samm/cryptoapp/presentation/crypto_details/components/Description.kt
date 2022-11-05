package com.samm.cryptoapp.presentation.crypto_details.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.presentation.crypto_details.CoinPriceDetailsState
import com.samm.cryptoapp.presentation.crypto_details.openWebsite

@Composable
fun Description(data: CoinDetailsData) {

    Column(Modifier.border(
        width = 1.dp,
        color = MaterialTheme.colors.primary,
    )) {
        //Description Text
        Text(
            text = "Description:",
            modifier = Modifier.padding(15.dp),
            fontSize = 18.sp,
            color = Color.Cyan
        )
        Text(text = data.description, modifier = Modifier.padding(
            start = 15.dp, bottom = 15.dp, end = 15.dp
        ))
    }

}

