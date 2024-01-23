package com.example.githubapp.domain.usecase.getUserList

import com.example.githubapp.common.Resource
import com.example.githubapp.data.model.User
import com.example.githubapp.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetUserListUsecase @Inject constructor(private val repository: GithubRepository) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            val usersList = repository.getUsersList()
            emit(Resource.Success(usersList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server, Please check you internet."))
        }
    }
}