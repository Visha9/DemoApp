package com.example.data.model

import com.example.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserDTO(
    @SerializedName("login")
    val userId: String = "",
    @SerializedName("avatar_url")
    val avatarUrl: String = "",
    @SerializedName("html_url")
    val htmlUrl: String = "",
)


fun UserDTO.toUser(): User {
    return User(
        userId = this.userId,
        avatarUrl = this.avatarUrl
    )
}