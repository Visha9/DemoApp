package com.example.presentation.userdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.UserDetail
import com.example.presentation.userdetail.components.ReposList
import com.example.presentation.userdetail.components.ScoreSession

@Composable
fun UserDetailScreen(viewModel: UserDetailViewModel = hiltViewModel()) {
    val state = viewModel.state.value


    state.userDetail?.let {
        Column (
            modifier = Modifier.padding(10.dp)
        ){
            ReposList(
                header = { RepositoryHeader(it) },
                reposList = it.repositories
            )
        }

    }

}
@Composable
fun RepositoryHeader(
    userDetail: UserDetail
) {
    Column {
        ScoreSession(userDetail)
        UserDetailSession(userDetail)
        Divider()
    }

}
@Composable
fun UserDetailSession(userDetail: UserDetail) {
    Text(
        text = userDetail.name,
        style = MaterialTheme.typography.headlineSmall,
        fontWeight = FontWeight.Bold
    )
    Text(
        text = userDetail.location ?: "",
        style = MaterialTheme.typography.headlineSmall
    )


}