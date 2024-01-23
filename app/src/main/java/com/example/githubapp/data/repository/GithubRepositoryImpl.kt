package com.example.githubapp.data.repository

import com.example.githubapp.data.model.Repository
import com.example.githubapp.data.model.User
import com.example.githubapp.data.model.UserDetail
import com.example.githubapp.data.remote.GithubApi
import com.example.githubapp.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(private val api: GithubApi) :
    GithubRepository {
    override suspend fun getUsersList(): List<User> {
     return api.getUsers()
    }

    override suspend fun getUser(userId: String): UserDetail {
        return api.getUser(userId)
    }

    override suspend fun getRepo(userId: String): List<Repository> {
     return api.getRepos(userId)
    }

}