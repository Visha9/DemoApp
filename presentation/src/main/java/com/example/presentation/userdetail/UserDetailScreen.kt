package com.example.presentation.userdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.domain.model.UserDetailDomainModel
import com.example.presentation.R
import com.example.presentation.common.AlertDialog
import com.example.presentation.common.LoadingItem
import com.example.presentation.userdetail.components.ReposList
import com.example.presentation.userdetail.components.ScoreSession

@Composable
fun UserDetailScreen(viewModel: UserDetailViewModel = hiltViewModel()) {
    LaunchedEffect(Unit, block = {
        viewModel.getUser()
        viewModel.getUserRepositories()
    })
    val state by viewModel.state.collectAsState()
    when {
        state.isLoading -> LoadingItem(
            modifier = Modifier
                .fillMaxSize(),
            text = stringResource(R.string.loading_please_wait)
        )

        state.error.isNotEmpty() -> AlertDialog(
            state.error
        )

        else ->
            state.userDetail?.let {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    ReposList(
                        header = { RepositoryHeader(it) },
                        reposList = state.repositories
                    )
                }

            }
    }

}

@Composable
fun RepositoryHeader(
    userDetail: UserDetailDomainModel
) {
    Column {
        ScoreSession(userDetail)
        UserDetailSession(userDetail)
        Divider()
    }

}

@Composable
fun UserDetailSession(userDetail: UserDetailDomainModel) {
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