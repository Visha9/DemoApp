package com.example.domain.usecase.getUserList


import com.example.domain.Resource
import com.example.domain.model.User
import com.example.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val NETWORK_ERROR_MESSAGE = "Couldn't reach to server, Please check you internet."


class GetUserListUsecase @Inject constructor(private val repository: GithubRepository) {
    operator fun invoke(): Flow<Resource<List<User>>> = flow {
        try {
            emit(Resource.Loading())
            val usersList = repository.getUsersList()
            emit(Resource.Success(usersList))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage))
        } catch (e: IOException) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        }
    }
}