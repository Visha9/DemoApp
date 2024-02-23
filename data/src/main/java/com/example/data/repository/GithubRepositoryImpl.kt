package com.example.data.repository

import com.example.data.model.toRepository
import com.example.data.model.toUser
import com.example.data.model.toUserDetail
import com.example.data.remote.GithubApi
import com.example.domain.Resource
import com.example.domain.model.RepositoryDomainModel
import com.example.domain.model.UserDetailDomainModel
import com.example.domain.model.UserDomainModel
import com.example.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubApi) :
    GithubRepository {
    override suspend fun getUsersList(): Flow<Resource<List<UserDomainModel>>> {
        return fetchApiData(api.getUsers().map {
            it.toUser()
        })
    }

    override suspend fun getUser(userId: String): Flow<Resource<UserDetailDomainModel>> =
        fetchApiData(api.getUser(userId).toUserDetail())

    override suspend fun getRepo(userId: String): Flow<Resource<List<RepositoryDomainModel>>> =
        fetchApiData(api.getRepos(userId).map { it.toRepository() })

}