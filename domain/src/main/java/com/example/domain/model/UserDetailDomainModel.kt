package com.example.domain.model

data class UserDetailDomainModel(
    val avatarUrl: String = "",
    val htmlUrl: String = "",
    val name: String = "",
    val location: String? = "",
    val blogUrl: String = "",
    val publicRepos: Int = 0,
    val followers: Int = 0,
    val following: Int = 0
)