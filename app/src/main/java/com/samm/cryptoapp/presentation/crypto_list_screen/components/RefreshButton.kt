package com.samm.cryptoapp.presentation.crypto_list_screen.components

import android.content.Context
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import com.samm.cryptoapp.R
import com.samm.cryptoapp.presentation.viewmodel.CoinListViewModel

@Composable
fun RefreshButton(viewModel: CoinListViewModel, context: Context) {
    // Refresh Button
    IconButton(
        onClick = {
            viewModel.onRefreshDataEvent()
        },
        modifier = Modifier
            .semantics {
                contentDescription = "Refresh Button"
                testTag = context.getString(R.string.refresh_button_test_tag)
            },

    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Refresh Icon"
        )
    }
}