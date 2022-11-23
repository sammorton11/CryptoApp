package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.samm.cryptoapp.domain.model.CoinDetailsData

@Composable
fun Tags(data: CoinDetailsData) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(bottom = 25.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth()
            .semantics {
                testTag = "Tags Card Tag"
            }
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            // Team
            Text(
                text = "Tags",
                modifier = Modifier
                    .padding(15.dp)
                    .semantics {
                        testTag = "Tags Title Tag"
                    },
                fontSize = 18.sp,
                color = MaterialTheme.colors.onBackground
            )
            if (expanded){
                FlowRow(
                    mainAxisSpacing = 10.dp,
                    crossAxisSpacing = 10.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    data.tags.forEach { tag ->
                        Text(
                            text = "${tag?.name}  ",
                            modifier = Modifier.semantics {
                                testTag = "Tags Details Tag"
                            }
                        )
                    }
                }
            }
        }
    }
}