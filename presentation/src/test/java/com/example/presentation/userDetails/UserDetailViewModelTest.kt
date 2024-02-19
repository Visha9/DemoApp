package com.example.presentation.userDetails

import androidx.lifecycle.SavedStateHandle
import com.example.domain.Resource
import com.example.domain.model.UserDetail
import com.example.domain.usecase.getUserDetail.GetUserDetailUseCase
import com.example.domain.usecase.getUserDetail.GetUserRepoUsecase
import com.example.presentation.dispatchers.MainDispatcherRule
import com.example.presentation.userdetail.UserDetailViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class UserDetailViewModelTest {
    private val getUserDetailUseCase: GetUserDetailUseCase = mockk()
    private val getUserRepoUsecase: GetUserRepoUsecase = mockk()
    private lateinit var savedStateHandle: SavedStateHandle

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private lateinit var userListViewModel: UserDetailViewModel


    @Before
    fun setUp() {
        val valuesMap = mapOf("userId" to "123")
        savedStateHandle = SavedStateHandle(valuesMap)
        userListViewModel =
            UserDetailViewModel(getUserDetailUseCase, getUserRepoUsecase, savedStateHandle)
    }

    @Test
    fun `GIVEN user id WHEN getUser invoked then VERIFY success scenario called`() = runTest {
        coEvery {
            getUserDetailUseCase.invoke("123")
        } returns flowOf(Resource.Success(UserDetail(name = "test")))
        userListViewModel.getUser()
        val result = userListViewModel.state
        assert(result.value.userDetail?.name.equals("test"))
    }

    @Test
    fun `GIVEN user id WHEN getUser invoked then VERIFY error scenario called`() = runTest {
        coEvery {
            getUserDetailUseCase.invoke("123")
        } returns flowOf(Resource.Error(""))
        userListViewModel.getUser()
        val result = userListViewModel.state
        assert(result.value.error.equals(""))

    }

    @Test
    fun `GIVEN user id WHEN getUser invoked then VERIFY loading scenario called`() = runTest {
        coEvery {
            getUserDetailUseCase.invoke("123")
        } returns flowOf(Resource.Loading())
        userListViewModel.getUser()
        val result = userListViewModel.state
        assert(result.value.isLoading)
    }
}

