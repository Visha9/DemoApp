package com.example.presentation.userdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import com.example.domain.usecase.getUserDetail.GetUserDetailUseCase
import com.example.domain.usecase.getUserDetail.GetUserRepoUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userDetailUseCase:
    GetUserDetailUseCase,
    private val getUserRepoUsecase: GetUserRepoUsecase,
    private val savedStateHandle: SavedStateHandle
) :
    ViewModel() {
    private val _state = MutableStateFlow((UserDetailState()))
    val state: StateFlow<UserDetailState> = _state.asStateFlow()

    suspend fun getUser() {
        val userId = savedStateHandle.get<String>("userId") ?: ""
        viewModelScope.launch {
            when (val result = userDetailUseCase.invoke(userId)) {
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
        }
    }

    suspend fun getUserRepositories() {
        val userId = savedStateHandle.get<String>("userId") ?: ""
        CoroutineScope(Dispatchers.IO).launch {
            val result = getUserRepoUsecase.invoke(userId)
            when (result) {
                is Resource.Success -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        repositories = result.data
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
//        getUserRepoUsecase.invoke(userId).onEach { result ->
//            when (result) {
//                is Resource.Success -> {
//                    _state.value = _state.value.copy(
//                        isLoading = false,
//                        repositories = result.data ?: emptyList()
//                    )
//                }
//
//                is Resource.Error -> {
//                    _state.value = _state.value.copy(
//                        error = ""
//                    )
//                }
//
//                is Resource.Loading -> {
//                    _state.value = _state.value.copy(
//                        isLoading = true
//                    )
//                }
//            }
//        }.launchIn(viewModelScope)
        }
    }
}