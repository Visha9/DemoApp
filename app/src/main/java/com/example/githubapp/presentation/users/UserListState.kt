package com.example.githubapp.presentation.users

import com.example.githubapp.data.model.User


data class UserListState(
    val isLoading: Boolean = false,
    val userList: List<User> = emptyList(),
    val error: String = ""
)