package com.samm.cryptoapp.presentation.crypto_list_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samm.cryptoapp.common.Constants.LIST_AMOUNT

@Composable
fun Title() {
    Row(
        modifier = Modifier.padding(10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "Top $LIST_AMOUNT Crypto Coins",
            modifier = Modifier
                .semantics {
                    contentDescription = "Title"
                    testTag = "Title Test Tag"
                },
            color = MaterialTheme.colors.onBackground,
            fontSize = 25.sp
        )
    }
}