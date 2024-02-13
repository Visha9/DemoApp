package com.example.presentation.users.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.presentation.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopToolBar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.users_screen_top_bar_title),
                color = Color.Black,
            )
        },
        navigationIcon = {
            IconButton(onClick = {

            }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = ""
                )
            }
        }

    )
}