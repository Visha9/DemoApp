package com.example.presentation.users

import com.example.domain.model.User


data class UserListState(
    val isLoading: Boolean = false,
    val userList: List<User> = emptyList(),
    val error: String = ""
)