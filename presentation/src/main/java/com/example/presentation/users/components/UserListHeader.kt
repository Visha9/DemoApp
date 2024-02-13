package com.example.presentation.users.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.domain.model.User


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
