package com.example.data.repository

import com.example.data.mapper.UserMapper
import com.example.data.remote.GithubApi
import com.example.domain.Resource
import com.example.domain.model.RepositoryDomainModel
import com.example.domain.model.UserDetailDomainModel
import com.example.domain.model.UserDomainModel
import com.example.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val api: GithubApi,
    private val mapper: UserMapper
) :
    GithubRepository, HandleApiResponse() {
    override suspend fun getUsersList(): Resource<List<UserDomainModel>> {
        return fetchApiData({ api.getUsers() }, mapper::mapToUser)
    }

    override suspend fun getUser(userId: String): Resource<UserDetailDomainModel> {
        return fetchApiData({ api.getUser(userId) }, mapper::mapToUserDetail)
    }

    override suspend fun getRepo(userId: String): Resource<List<RepositoryDomainModel>> {
        return fetchApiData({ api.getRepos(userId) }, mapper::mapToUserRepos)
    }

}