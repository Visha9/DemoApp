package com.example.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.presentation.theme.PurpleGrey40

@Composable
fun LoadingItem(
    modifier: Modifier,
    text: String = "Loading data..."
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        modifier = modifier
    ) {
        CircularProgressIndicator(color = PurpleGrey40)
        Text(
            text = text,
            style = MaterialTheme.typography.bodyLarge,
            color = PurpleGrey40
        )
    }

}