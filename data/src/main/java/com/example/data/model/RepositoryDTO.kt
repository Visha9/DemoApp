package com.example.data.model

import com.example.domain.model.RepositoryDomainModel
import com.google.gson.annotations.SerializedName

data class RepositoryDTO(
    @SerializedName("id") val id: Long = 0,
    @SerializedName("name") val name: String = "",
    @SerializedName("description") val description: String? = null,
    @SerializedName("watchers_count") val watchersCount: Int = 0,
    @SerializedName("forks_count") val forksCount: Int = 0,
    @SerializedName("stargazers_count") val stargazersCount: Int = 0,
    @SerializedName("language") val language: String? = null,
    @SerializedName("html_url") val htmlUrl: String = "",
)

fun RepositoryDTO.toRepository(): RepositoryDomainModel {
    return RepositoryDomainModel(
        id = this.id,
        name = this.name,
        description = this.description,
        watchersCount = this.watchersCount,
        forksCount = this.forksCount,
        language = this.language
    )
}

