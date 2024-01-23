package com.example.githubapp.presentation.userdetail

import com.example.githubapp.data.model.UserDetail

data class UserDetailState(
    val isLoading: Boolean = false,
    val userDetail: UserDetail? = null,
    val error: String = ""
)
