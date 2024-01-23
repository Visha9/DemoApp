package com.example.githubapp.data.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("login")
    val userId: String = "",
    @SerializedName("avatar_url")
    val avatarUrl: String = "",
    @SerializedName("html_url")
    val htmlUrl: String = "",
)