package com.example.data.model

import com.example.domain.model.RepositoryDomainModel
import com.example.domain.model.UserDetailDomainModel
import com.google.gson.annotations.SerializedName

data class UserDetailDTO(
    @SerializedName("avatar_url") val avatarUrl: String = "",
    @SerializedName("html_url") val htmlUrl: String = "",
    @SerializedName("name") val name: String = "",
    @SerializedName("location") val location: String? = "",
    @SerializedName("blog") val blogUrl: String = "",
    @SerializedName("public_repos") val publicRepos: Int = 0,
    @SerializedName("followers") val followers: Int = 0,
    @SerializedName("following") val following: Int = 0,
    val repositories: List<RepositoryDomainModel> = emptyList()
)

fun UserDetailDTO.toUserDetail(): UserDetailDomainModel {
    return UserDetailDomainModel(
        avatarUrl = this.avatarUrl,
        name = this.name,
        location = this.location,
        blogUrl = this.blogUrl,
        publicRepos = this.publicRepos,
        followers = this.followers,
        following = this.following

    )
}