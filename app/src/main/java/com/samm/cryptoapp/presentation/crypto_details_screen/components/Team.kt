package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
fun Team(data: CoinDetailsData) {

    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(bottom = 25.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth()
            .semantics {
                testTag = "Team Card Tag"
            }
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            if (data.team != null) {
                Text(
                    text = "Team",
                    modifier = Modifier
                        .padding(15.dp)
                        .semantics {
                                   testTag = "Team Card Title Tag"
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
                        data.team.forEach { team ->
                            Text(
                                text = "${team.name} - ${team.position}",
                                modifier = Modifier.semantics {
                                    testTag = "Team Details Tag"
                                }
                            )
                        }
                    }
                } else {
                    Box{}
                }
            } else {
                Text(text = "Not Available")
            }
        }

    }
}