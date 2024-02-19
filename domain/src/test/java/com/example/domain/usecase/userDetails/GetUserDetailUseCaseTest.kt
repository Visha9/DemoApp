package com.example.domain.usecase.userDetails


import com.example.domain.Resource
import com.example.domain.model.UserDetail
import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.getUserDetail.GetUserDetailUseCase
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
class GetUserDetailUseCaseTest {
    private val githubRepository: GithubRepository = mockk()
    private lateinit var userDetailUseCase: GetUserDetailUseCase


    @Before
    fun setUp() {
        userDetailUseCase = GetUserDetailUseCase(githubRepository)

    }

    @Test
    fun `GIVEN user id WHEN usecase invoked THEN verify repository called`() =
        runTest {
            coEvery {
                githubRepository.getUser("user_id")

            } returns flow { emit(Resource.Loading()) }
            userDetailUseCase.invoke("user_id")
            coVerify {
                githubRepository.getUser("user_id")
            }
        }
}