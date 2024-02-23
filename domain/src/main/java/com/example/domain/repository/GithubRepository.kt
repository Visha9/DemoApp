package com.example.domain.repository

import com.example.domain.Resource
import com.example.domain.model.RepositoryDomainModel
import com.example.domain.model.UserDomainModel
import com.example.domain.model.UserDetailDomainModel
import kotlinx.coroutines.flow.Flow

interface GithubRepository {
    suspend fun getUsersList(): Flow<Resource<List<UserDomainModel>>>
    suspend fun getUser(userId: String): Flow<Resource<UserDetailDomainModel>>
    suspend fun getRepo(userId: String): Flow<Resource<List<RepositoryDomainModel>>>
}