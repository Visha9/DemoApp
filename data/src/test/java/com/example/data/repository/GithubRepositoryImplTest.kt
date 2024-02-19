package com.example.data.repository


import com.example.data.model.UserDetailDTO
import com.example.data.remote.GithubApi
import com.example.domain.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import java.io.IOException

@OptIn(ExperimentalCoroutinesApi::class)
class GithubRepositoryImplTest {
    private lateinit var githubRepositoryImpl: GithubRepositoryImpl
    private var githubApiService: GithubApi = mockk()


    @Before
    fun setUp() {
        githubRepositoryImpl = GithubRepositoryImpl(
            githubApiService
        )
    }


    @Test
    fun `GIVEN users list WHEN repository called then emit Loading & Success`() = runTest {
        coEvery {
            githubApiService.getUsers()
        } returns emptyList()
        val result = githubRepositoryImpl.getUsersList().toList()
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Success)
    }

    @Test
    fun `GIVEN users list WHEN repository called then emit Loading & Error`() = runTest {
        coEvery {
            githubApiService.getUsers()
        } throws IOException("")
        val result = githubRepositoryImpl.getUsersList().toList()
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Error)
    }

    @Test
    fun `GIVEN user id WHEN User repository called then emit Loading & Error`() = runTest {
        coEvery {
            githubApiService.getUser("")
        } throws IOException("")
        val result = githubRepositoryImpl.getUser("").toList()
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Error)
    }

    @Test
    fun `GIVEN user id WHEN User repository called then emit Success`() = runTest {
        coEvery {
            githubApiService.getUser("user_id")
        } returns UserDetailDTO()
        val result = githubRepositoryImpl.getUser("user_id").toList()
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Success)
    }

    @Test
    fun `GIVEN user id WHEN getRepo repository called then emit Error`() = runTest {
        coEvery {
            githubApiService.getRepos("user_id")
        } throws IOException("")
        val result = githubRepositoryImpl.getRepo("user_id").toList()
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Error)
    }

    @Test
    fun `GIVEN user id WHEN getRepo repository called then emit Success`() = runTest {
        coEvery {
            githubApiService.getRepos("user_id")
        } returns emptyList()
        val result = githubRepositoryImpl.getRepo("user_id").toList()
        assert(result[0] is Resource.Loading)
        assert(result[1] is Resource.Success)
    }
}
