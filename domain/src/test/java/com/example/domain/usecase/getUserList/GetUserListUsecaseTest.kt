package com.example.domain.usecase.getUserList


import com.example.domain.Resource
import com.example.domain.model.UserDetail
import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.getUserDetail.GetUserDetailUseCase
import com.example.domain.usecase.getUserList.GetUserListUsecase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetUserListUsecaseTest {
    private val githubRepository: GithubRepository = mockk()
    private lateinit var userDetailUseCase: GetUserListUsecase


    @Before
    fun setUp() {
        userDetailUseCase = GetUserListUsecase(githubRepository)

    }

    @Test
    fun `GIVEN user id WHEN usecase invoked THEN verify repository called`() =
        runTest {
            coEvery {
                githubRepository.getUsersList()

            } returns flow { emit(Resource.Loading()) }
            userDetailUseCase.invoke()
            coVerify {
                githubRepository.getUsersList()
            }
        }
}