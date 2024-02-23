package com.example.presentation.users

import com.example.domain.model.UserDomainModel


data class UserListState(
    val isLoading: Boolean = false,
    val userList: List<UserDomainModel> = emptyList(),
    val error: String = ""
)