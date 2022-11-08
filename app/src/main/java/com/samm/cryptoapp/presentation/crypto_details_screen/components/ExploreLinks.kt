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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samm.cryptoapp.common.Constants
import com.samm.cryptoapp.domain.model.CoinDetailsData

@Composable
fun ExploreLinks(data: CoinDetailsData, navController: NavController) {
    val dataLinksExtended = data.links?.explorer
    val website = data.linksExtended[0]?.url
    var expanded by remember { mutableStateOf(false) }
    var cardLength by remember { mutableStateOf(0.dp) }
    Card(
        Modifier
            .padding(bottom = 25.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth()
    ) {
        cardLength = 0.dp

        Column(
            modifier = Modifier.padding(cardLength),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Explore",
                modifier = Modifier.padding(15.dp),
                fontSize = Constants.HEADING_SIZE,
                color = MaterialTheme.colors.onBackground
            )
            if (expanded) {
                Column(
                    modifier = Modifier.padding(15.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    // Link Buttons to the Coins website
                    website?.let {
                        WebsiteButton(websiteLink = it, navController = navController)
                    }
                    // Extend the card length -- doesn't extend far enough
                    cardLength = 15.dp
                    // Link Buttons to "explore" websites
                    dataLinksExtended?.forEach { link ->
                        link?.let {
                            WebsiteButton(websiteLink = link, navController = navController)
                        }
                    }
                }

            }
        }
    }
}