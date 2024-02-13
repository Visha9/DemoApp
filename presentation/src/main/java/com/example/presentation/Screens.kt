package com.example.presentation

sealed class Screens(val route: String) {
    data object UserListScreen : Screens("user_list_screen")
    data object UserDetailScreen : Screens("user_detail_screen")
}