package com.example.data


import com.example.data.model.UserDetailDTO
import com.example.data.remote.GithubApi
import com.example.data.repository.GithubRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


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
    fun `getUsers emit data when list from flow is empty`() = runBlocking {
        coEvery {
            githubApiService.getUsers()
        } returns emptyList()
        val result = githubRepositoryImpl.getUsersList()
        assert(result.isEmpty())
    }

    @Test
    fun `getUser emit data when user id is passed`() = runBlocking {
        coEvery {
            githubApiService.getUser("ABC")
        } returns UserDetailDTO(name = "User1")
        val result = githubRepositoryImpl.getUser("ABC")
        assert(result.name.equals("User1"))
    }

    @Test
    fun `getRepo emit data when user id is passed`() = runBlocking {
        coEvery {
            githubApiService.getRepos("ABC")
        } returns emptyList()
        val result = githubRepositoryImpl.getRepo("ABC")
        assert(result.isEmpty())
    }
}
