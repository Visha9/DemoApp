package com.example.presentation.users.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.domain.model.UserDomainModel


@Composable
fun UsersListHeader(
    users: List<UserDomainModel>,
    onItemClick: (UserDomainModel) -> Unit
) {
    LazyColumn {
        items(users) { user ->
            UsersListItem(user = user, onItemClick = onItemClick)
        }
    }
}
