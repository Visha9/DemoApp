package com.example.domain.model

data class RepositoryDomainModel(
    val id: Long = 0,
    val name: String = "",
    val description: String? = null,
    val watchersCount: Int = 0,
    val forksCount: Int = 0,
    val stargazersCount: Int = 0,
    val language: String? = null,
    val htmlUrl: String = "",
)