package com.samm.cryptoapp.presentation.crypto_details.components

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import com.samm.cryptoapp.common.Constants.HEADING_SIZE
import com.samm.cryptoapp.domain.model.CoinDetailsData
import com.samm.cryptoapp.presentation.crypto_details.openWebsite

@Composable
fun ExploreLinks(data: CoinDetailsData, context: Context) {
    val dataLinksExtended = data.links?.explorer

    Text(
        text = "Explore:",
        modifier = Modifier.padding(bottom = 25.dp),
        fontSize = HEADING_SIZE,
        color = MaterialTheme.colors.primary
    )
    dataLinksExtended?.forEach {
        if (it != null){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {openWebsite(it, context)},
                    modifier = Modifier.width(325.dp)
                ) {
                    Text(
                        text = "$it",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }
            }

        }
    }
}


@Composable
fun SocialMediaLinks(data: CoinDetailsData, context: Context) {

    val dataLinks = data.links
    val youTube = dataLinks?.youtube
    val facebook = dataLinks?.facebook
    val reddit = dataLinks?.reddit
    val sourceCode = dataLinks?.source_code

    val list = listOf(youTube, facebook, reddit, sourceCode)

    Text(
        text = "Social Media:",
        modifier = Modifier.padding(bottom = 25.dp),
        fontSize = HEADING_SIZE,
        color = MaterialTheme.colors.primary
    )

    FlowRow(
        mainAxisSpacing = 10.dp,
        crossAxisSpacing = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp)
    ) {
        list.forEach { link ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { link?.first()?.let { openWebsite(it, context) } },
                    modifier = Modifier.width(325.dp)
                ) {
                    Text(
                        text = "${link?.first()}",
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                }

            }

        }
    }
}