package com.example.presentation.userdetail

import com.example.domain.model.RepositoryDomainModel
import com.example.domain.model.UserDetailDomainModel

data class UserDetailState(
    val isLoading: Boolean = false,
    val userDetail: UserDetailDomainModel? = null,
    val error: String = "",
    val repositories: List<RepositoryDomainModel> = emptyList()
)
