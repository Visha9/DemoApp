package com.example.data.remote

import com.example.data.model.RepositoryDTO
import com.example.data.model.UserDTO
import com.example.data.model.UserDetailDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {

    @GET("/users")
    suspend fun getUsers(): Response<List<UserDTO>>

    @GET("/users/{userLogin}")
    suspend fun getUser(@Path("userLogin") userId: String): Response<UserDetailDTO>

    @GET("/users/{userLogin}/repos")
    suspend fun getRepos(@Path("userLogin") userId: String): Response<List<RepositoryDTO>>
}