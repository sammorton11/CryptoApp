package com.samm.cryptoapp.presentation.crypto_details_screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samm.cryptoapp.presentation.navigation.Screen
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun WebsiteButton(websiteLink: String, navController: NavController) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                //openWebsite(websiteLink, context)
                val url = URLEncoder.encode(websiteLink, StandardCharsets.UTF_8.toString())
                navController.navigate(
                    Screen.WebViewScreen.route + "/${url}"
                )
            },
            modifier = Modifier.width(300.dp)
        ){
            Text(
                text = "$websiteLink",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}