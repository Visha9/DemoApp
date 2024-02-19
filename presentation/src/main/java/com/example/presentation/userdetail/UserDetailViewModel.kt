package com.example.presentation.userdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import com.example.domain.usecase.getUserDetail.GetUserDetailUseCase
import com.example.domain.usecase.getUserDetail.GetUserRepoUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase:
    GetUserDetailUseCase,
    private val getUserRepoUsecase: GetUserRepoUsecase,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    suspend fun getUser() {
        val userId = savedStateHandle.get<String>("userId") ?: ""
        userDetailUseCase.invoke(userId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        userDetail = result.data
                    )
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        error = ""
                    )
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    suspend fun getUserRepositories() {
        val userId = savedStateHandle.get<String>("userId") ?: ""
        getUserRepoUsecase.invoke(userId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        repositories = result.data ?: emptyList()
                    )
                }

                is Resource.Error -> {
                    _state.value = _state.value.copy(
                        error = ""
                    )
                }

                is Resource.Loading -> {
                    _state.value = _state.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}