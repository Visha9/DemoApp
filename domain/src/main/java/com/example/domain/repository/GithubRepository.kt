package com.example.domain.repository

import com.example.domain.model.Repository
import com.example.domain.model.User
import com.example.domain.model.UserDetail


interface GithubRepository {
    suspend fun getUsersList(): List<User>
    suspend fun getUser(userId: String): UserDetail
    suspend fun getRepo(userId: String): List<Repository>
}