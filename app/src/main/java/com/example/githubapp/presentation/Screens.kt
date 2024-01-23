package com.example.githubapp.presentation

sealed class Screens(val route: String) {
    object UserListScreen : Screens("user_list_screen")
    object UserDetailScreen : Screens("user_detail_screen")
}