package com.example.presentation.users

import com.example.domain.Resource
import com.example.domain.model.UserDomainModel
import com.example.domain.usecase.getUserList.GetUserListUsecase
import com.example.presentation.dispatchers.MainDispatcherRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserListViewModelTest {
    private val userListUsecase: GetUserListUsecase = mockk()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var userListViewModel: UserListViewModel


    @Before
    fun setUp() {
        userListViewModel = UserListViewModel(userListUsecase)

    }

    @Test
    fun ` WHEN getUsers invoked then VERIFY success scenario called`() = runTest {
        val listOfItems = listOf(UserDomainModel(userId = "123"))
        coEvery {
            userListUsecase.invoke()
        } returns flowOf(Resource.Success(listOfItems))
        userListViewModel.getUsersList()
        val result = userListViewModel.state
        assert(result.value.userList.size == 1)
    }


    @Test
    fun ` WHEN getUsers invoked then VERIFY loading scenario called`() {

        runTest {
            coEvery {
                userListUsecase.invoke()
            } returns flowOf(Resource.Loading())
            userListViewModel.getUsersList()
            val result = userListViewModel.state
            assert(result.value.isLoading)
        }
    }

    @Test
    fun `WHEN getUsers invoked then VERIFY error scenario called`() {
        runTest {
            coEvery {
                userListUsecase.invoke()
            } returns flowOf(Resource.Error("Error"))
            userListViewModel.getUsersList()
            val result = userListViewModel.state
            assert(result.value.error.equals("Error"))
        }
    }
}

