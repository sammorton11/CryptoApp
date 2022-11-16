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
fun SocialMediaLinks(data: CoinDetailsData, navController: NavController) {

    val dataLinks = data.links
    val youTube = dataLinks?.youtube
    val facebook = dataLinks?.facebook
    val reddit = dataLinks?.reddit
    val sourceCode = dataLinks?.source_code
    var expanded by remember { mutableStateOf(false) }
    val list = listOf(youTube, facebook, reddit, sourceCode)
    var cardLength by remember { mutableStateOf(0.dp) }

    Card(
        Modifier
            .padding(bottom = 25.dp)
            .clickable { expanded = !expanded }
            .fillMaxWidth()
    ) {
        cardLength = 0.dp

        Column(
            modifier = Modifier.padding(bottom = cardLength),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Social Media",
                modifier = Modifier.padding(15.dp),
                fontSize = Constants.HEADING_SIZE,
                color = MaterialTheme.colors.onBackground
            )
            if (expanded){
                Column(
                    modifier = Modifier.padding(15.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    cardLength = 15.dp // Extend the card length -- doesn't extend far enough
                    list.forEach { link ->
                        val url = link.toString()
                        if (url.isNotEmpty()){
                            WebsiteButton(websiteLink = url, navController = navController)
                        }
                    }
                }
            }
        }
    }
}