package com.example.data.repository

import com.example.data.model.toRepository
import com.example.data.model.toUser
import com.example.data.model.toUserDetail
import com.example.data.remote.GithubApi
import com.example.domain.model.Repository
import com.example.domain.model.User
import com.example.domain.model.UserDetail
import com.example.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubApi) :
    GithubRepository {
    override suspend fun getUsersList(): List<User> {
        return api.getUsers().map {
            it.toUser()
        }
    }

    override suspend fun getUser(userId: String): UserDetail {
        return api.getUser(userId).toUserDetail()
    }

    override suspend fun getRepo(userId: String): List<Repository> {
        return api.getRepos(userId).map {
            it.toRepository()
        }
    }

}