package com.example.githubapp.domain.repository

import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.data.model.UserDetail

interface GithubRepository {
    suspend fun getUsersList(): List<User>
    suspend fun getUser(userId: String): UserDetail
    suspend fun getRepo(userId: String) : List<Repository>
}