package com.example.githubapp.presentation.userdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.common.Resource
import com.example.githubapp.domain.usecase.getUserDetail.GetUserDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase:
    GetUserDetailUseCase,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = mutableStateOf(UserDetailState())
    val state: State<UserDetailState> = _state

    init {
        getUser()
    }

    private fun getUser() {
        val userId = savedStateHandle.get<String>("userId") ?: ""
        userDetailUseCase.invoke(userId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserDetailState(userDetail = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        UserDetailState(error = result.message ?: "Unexpected error occurred!")
                }

                is Resource.Loading -> {
                    _state.value = UserDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)

    }


}