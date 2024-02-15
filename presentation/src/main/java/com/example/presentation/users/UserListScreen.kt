package com.example.presentation.users

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.presentation.R
import com.example.presentation.common.LoadingItem
import com.example.presentation.users.components.TopToolBar

import com.example.presentation.users.components.UsersListHeader

@Composable
fun UsersListScreen(
    navController: NavController,
    viewModel: UserListViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit, block = {
        viewModel.getUsersList()
    })

    val state = viewModel.state.value
    Column {
        TopToolBar()
        if (state.isLoading) {
            LoadingItem(
                modifier = Modifier
                    .fillMaxSize(),
                text = stringResource(R.string.loading_please_wait)
            )
        } else {
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

}