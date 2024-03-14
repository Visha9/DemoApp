package com.example.domain.usecase.getUserList


import com.example.domain.repository.GithubRepository
import javax.inject.Inject


class GetUserListUsecase @Inject constructor(private val repository: GithubRepository) {

    suspend  fun invoke() = repository.getUsersList()

}