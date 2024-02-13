package com.example.domain.usecase


import com.example.domain.model.UserDetail
import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.getUserDetail.GetUserDetailUseCase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetUserDetailUseCaseTest {
    private val githubRepository: GithubRepository = mockk()
    private lateinit var userDetailUseCase: GetUserDetailUseCase


    @Before
    fun setUp() {
        userDetailUseCase = GetUserDetailUseCase(githubRepository)

    }

    @Test
    fun `GIVEN user id WHEN usecase invoked THEN verify repository called`() =
        runBlocking {
            coEvery {
                githubRepository.getUser("ABCD")

            } returns UserDetail()
            userDetailUseCase.invoke("ABCD")
            coVerify {
                githubRepository.getUser("ABCD")
            }
        }
}