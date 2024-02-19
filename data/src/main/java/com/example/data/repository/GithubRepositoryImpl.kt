package com.example.data.repository

import com.example.data.model.toRepository
import com.example.data.model.toUser
import com.example.data.model.toUserDetail
import com.example.data.remote.GithubApi
import com.example.domain.Resource
import com.example.domain.model.Repository
import com.example.domain.model.User
import com.example.domain.model.UserDetail
import com.example.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val NETWORK_ERROR_MESSAGE = "Couldn't reach to server, Please check you internet."


class GithubRepositoryImpl @Inject constructor(private val api: GithubApi) :
    GithubRepository {
    override suspend fun getUsersList(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(api.getUsers().map {
                it.toUser()
            }))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: ""
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        }

    }

    override suspend fun getUser(userId: String): Flow<Resource<UserDetail>> = flow {
        try {
            emit(Resource.Loading())
            emit(Resource.Success(api.getUser(userId).toUserDetail()))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: ""
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        }
    }

    override suspend fun getRepo(userId: String): Flow<Resource<List<Repository>>> = flow {
        try {
            emit(Resource.Loading())
            val repos = api.getRepos(userId).map { it.toRepository() }
            emit(Resource.Success(repos))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: ""
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        }
    }

}