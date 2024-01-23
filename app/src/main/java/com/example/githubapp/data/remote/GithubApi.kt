package com.example.githubapp.data.remote

import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.data.model.UserDetail
import retrofit2.http.GET
import retrofit2.http.Path
interface GithubApi {

    @GET("/users")
    suspend fun getUsers(): List<User>

    @GET("/users/{userLogin}")
    suspend fun getUser(@Path("userLogin") userId: String): UserDetail

    @GET("/users/{userLogin}/repos")
    suspend fun getRepos(@Path("userLogin") userId: String): List<Repository>
}