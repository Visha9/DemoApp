package com.example.domain.repository

import com.example.domain.Resource
import com.example.domain.model.Repository
import com.example.domain.model.User
import com.example.domain.model.UserDetail
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun getUsersList(): Flow<Resource<List<User>>>
    suspend fun getUser(userId: String): Flow<Resource<UserDetail>>
    suspend fun getRepo(userId: String): Flow<Resource<List<Repository>>>
}