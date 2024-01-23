package com.example.githubapp.domain.usecase.getUserDetail

import com.example.githubapp.common.Resource
import com.example.githubapp.data.model.User
import com.example.githubapp.data.model.UserDetail
import com.example.githubapp.domain.repository.GithubRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

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
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred!"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server, Please check you internet."))
        }
    }
}