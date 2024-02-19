package com.example.domain.usecase.getUserDetail

import com.example.domain.repository.GithubRepository
import javax.inject.Inject

class GetUserRepoUsecase @Inject constructor(private val repository: GithubRepository) {

    suspend operator fun invoke(userId: String) = repository.getRepo(userId)
}