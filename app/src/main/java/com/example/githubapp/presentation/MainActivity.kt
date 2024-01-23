package com.example.githubapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.githubapp.presentation.userdetail.UserDetailScreen
import com.example.githubapp.presentation.users.UsersListScreen
import com.example.githubapp.ui.theme.GithubAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubAppTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination =Screens.UserListScreen.route
                ) {
                    composable(
                        route = Screens.UserListScreen.route
                    ) {
                        UsersListScreen(navController)
                    }
                    composable(
                        route = Screens.UserDetailScreen.route + "/{userId}",
                                arguments = listOf(navArgument(name = "userId") {
                            type = NavType.StringType
                        })
                    ) {
                        UserDetailScreen()
                    }
                }
            }
        }
    }
}

