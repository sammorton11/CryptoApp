package com.samm.cryptoapp.presentation.web_view_screen

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun WebViewScreen(mUrl: String) {
    Scaffold(
        topBar = { TopAppBar(
                title = { Text("Crypto | WebView", color = MaterialTheme.colors.primary) },
                backgroundColor = MaterialTheme.colors.onPrimary) },
        content = {
            WebViewContent(mUrl = mUrl)
        }
    )
}