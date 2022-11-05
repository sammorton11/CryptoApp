package com.samm.cryptoapp.presentation.crypto_details.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samm.cryptoapp.common.Constants.HEADING_SIZE
import com.samm.cryptoapp.domain.model.CoinDetailsData

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
            fontSize = HEADING_SIZE,
            color = Color.Cyan
        )
        data.description?.let {
            Text(text = it, modifier = Modifier.padding(
                start = 15.dp, bottom = 15.dp, end = 15.dp
            ))
        }
    }


}

