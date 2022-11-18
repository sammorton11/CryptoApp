package com.samm.cryptoapp.presentation.crypto_list_screen.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.samm.cryptoapp.common.Constants.cornerShape
import com.samm.cryptoapp.domain.model.CoinData

@Composable
fun CoinListItem(
    coin: CoinData,
    onItemClick: (CoinData) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .border(
                width = 1.dp,
                color = Color.Transparent,
                shape = RoundedCornerShape(cornerShape)
            )
            .clickable {
                onItemClick(coin)
            }
            .semantics {
                contentDescription = "Coin Card"
                testTag = "Coin Card Tag"
            },
        shape = RoundedCornerShape(cornerShape),
        backgroundColor = MaterialTheme.colors.secondary,
        elevation = 25.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .semantics {
                    testTag = "Card Row Button"
                    contentDescription = "Coin Details Link" },
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "${coin.rank}.  ${coin.name} (${coin.symbol})",
                modifier = Modifier
                    .semantics {
                        contentDescription = "Coin Card Labels Data"
                        testTag = "Coin Card Labels Tag"
                    },
                color = MaterialTheme.colors.onBackground,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = if(coin.is_active) "active" else "inactive",
                color = if(coin.is_active) Color.Green else Color.Red,
                textAlign = TextAlign.End,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .align(CenterVertically)
                    .semantics {
                        contentDescription = "Coin Activity"
                        testTag = "Coin Activity Tag"
                    }
            )
        }
    }
}