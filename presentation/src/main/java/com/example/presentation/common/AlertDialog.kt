package com.example.presentation.common

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.presentation.R

@Composable
fun AlertDialog(errorMessage: String) {
    androidx.compose.material3.AlertDialog(
        onDismissRequest = { },
        title = { Text(text = stringResource(id = R.string.alert)) },
        text = { Text(text = errorMessage) },
        confirmButton = {
            TextButton(onClick = {})
            { Text(text = stringResource(id = R.string.ok)) }
        }
    )
}