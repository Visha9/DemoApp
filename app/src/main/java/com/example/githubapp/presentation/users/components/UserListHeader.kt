package com.example.githubapp.presentation.users.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R
import com.example.githubapp.data.model.User


@Composable
fun UsersListHeader(
    users: List<User>,
    onItemClick: (User) -> Unit
) {
    LazyColumn {
        items(users) { user ->
            UsersListItem(user = user, onItemClick = onItemClick)
        }
    }
}
