package com.example.githubapp.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubapp.common.Resource
import com.example.githubapp.domain.usecase.getUserList.GetUserListUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val usersListUsecase: GetUserListUsecase) :
    ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    init {
        getUsersList()
    }

    /**
     * This function get the Users List from Repository via UserListUsecase
     */
    private fun getUsersList() {
        usersListUsecase.invoke().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = UserListState(userList = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value =
                        UserListState(error = result.message ?: "Unexpected error occurred!")
                }
                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
            }

        }.launchIn(viewModelScope)
    }

}