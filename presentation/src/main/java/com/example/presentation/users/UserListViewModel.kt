package com.example.presentation.users

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val usersListUsecase: com.example.domain.usecase.getUserList.GetUserListUsecase) :
    ViewModel() {

    private val _state = mutableStateOf(UserListState())
    val state: State<UserListState> = _state

    /**
     * This function get the Users List from Repository via UserListUsecase
     */
    suspend fun getUsersList() {
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