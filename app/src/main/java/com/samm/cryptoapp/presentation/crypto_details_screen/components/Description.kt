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
import com.samm.cryptoapp.common.Constants.HEADING_SIZE
import com.samm.cryptoapp.domain.model.CoinDetailsData

@Composable
fun Description(data: CoinDetailsData) {

    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(bottom = 25.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth()
            .semantics {
                testTag = "Description Card Tag"
            }
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            if (!expanded){
                //Description Text
                Text(
                    text = "Description",
                    modifier = Modifier
                        .padding(15.dp)
                        .semantics {
                            testTag = "Description Title Tag"
                        },
                    fontSize = HEADING_SIZE,
                    color = MaterialTheme.colors.onBackground
                )
            }


            if (expanded){
                data.name?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(15.dp),
                        fontSize = HEADING_SIZE,
                        color = MaterialTheme.colors.onBackground
                    )
                }

                data.description?.let {
                    Text(text = it, modifier = Modifier.padding(
                        start = 15.dp, bottom = 15.dp, end = 15.dp
                    ))
                }
            }
        }
    }
}

