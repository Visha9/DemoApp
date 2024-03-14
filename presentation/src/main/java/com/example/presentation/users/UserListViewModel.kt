package com.example.presentation.users


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.Resource
import com.example.domain.usecase.getUserList.GetUserListUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val usersListUsecase: GetUserListUsecase) :
    ViewModel() {

    private val _state = MutableStateFlow(UserListState(isLoading = true))
    val state: StateFlow<UserListState> = _state.asStateFlow()

    /**
     * This function get the Users List from Repository via UserListUsecase
     */
    suspend fun getUsersList() {
        viewModelScope.launch {
            val result = usersListUsecase.invoke()

            when (result) {
                is Resource.Success -> {
                    _state.value = UserListState(userList = result.data)
                }

                is Resource.Error -> {
                    _state.value =
                        UserListState(error = result.message)
                }

                is Resource.Loading -> {
                    _state.value = UserListState(isLoading = true)
                }
            }

        }
    }

}