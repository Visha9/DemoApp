package com.example.presentation.users

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.presentation.users.components.TopToolBar

import com.example.presentation.users.components.UsersListHeader

@Composable
fun UsersListScreen(
    navController: NavController,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Column {
        TopToolBar()
        UsersListHeader(
            state.userList,
            onItemClick = {
                navController.navigate(
                    "user_detail_screen" +
                            "/${it.userId}"
                )
            }
        )
    }

}