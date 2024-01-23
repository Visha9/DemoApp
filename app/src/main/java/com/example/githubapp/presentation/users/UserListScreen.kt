package com.example.githubapp.presentation.users

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.githubapp.data.model.User
import com.example.githubapp.presentation.users.components.TopToolBar

import com.example.githubapp.presentation.users.components.UsersListHeader

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
                navController.navigate("user_detail_screen" +
                        "/${it.userId}")
            }
        )
    }

}