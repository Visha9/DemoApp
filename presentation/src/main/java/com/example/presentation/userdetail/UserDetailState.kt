package com.example.presentation.userdetail

import com.example.domain.model.UserDetail

data class UserDetailState(
    val isLoading: Boolean = false,
    val userDetail: UserDetail? = null,
    val error: String = ""
)