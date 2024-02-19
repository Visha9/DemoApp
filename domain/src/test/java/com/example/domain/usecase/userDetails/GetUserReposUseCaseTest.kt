package com.example.domain.usecase.userDetails


import com.example.domain.Resource
import com.example.domain.repository.GithubRepository
import com.example.domain.usecase.getUserDetail.GetUserRepoUsecase
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class GetUserReposUseCaseTest {
    private val githubRepository: GithubRepository = mockk()
    private lateinit var userRepoUseCase: GetUserRepoUsecase


    @Before
    fun setUp() {
        userRepoUseCase = GetUserRepoUsecase(githubRepository)

    }

    @Test
    fun `GIVEN user id WHEN usecase invoked THEN verify repository called`() =
        runTest {
            coEvery {
                githubRepository.getRepo("user_id")

            } returns flow { emit(Resource.Loading()) }
            userRepoUseCase.invoke("user_id")
            coVerify {
                githubRepository.getRepo("user_id")
            }
        }
}