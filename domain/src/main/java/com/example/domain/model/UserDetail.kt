package com.example.domain.model

data class UserDetail(
    val avatarUrl: String = "",
    val htmlUrl: String = "",
    val name: String = "",
    val location: String? = "",
    val blogUrl: String = "",
    val publicRepos: Int = 0,
    val followers: Int = 0,
    val following: Int = 0,
    val repositories: List<Repository> = emptyList()
)