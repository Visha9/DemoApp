package com.example.domain.usecase.getUserDetail


import com.example.domain.Resource
import com.example.domain.model.UserDetail
import com.example.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

private const val HTTP_ERROR_MESSAGE = "An unexpected error occurred!"
private const val NETWORK_ERROR_MESSAGE = "Couldn't reach to server, Please check you internet."


class GetUserDetailUseCase @Inject constructor(private val repository: GithubRepository) {
    operator fun invoke(userId: String): Flow<Resource<UserDetail>> = flow {
        try {
            emit(Resource.Loading())
            val userDetail = repository.getUser(userId)
            val repos = repository.getRepo(userId)
            val detail = userDetail.copy(
                repositories = repos
            )
            emit(Resource.Success(detail))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: HTTP_ERROR_MESSAGE))
        } catch (e: IOException) {
            emit(Resource.Error(NETWORK_ERROR_MESSAGE))
        }
    }
}