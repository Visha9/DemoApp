package com.example.presentation.userdetail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.domain.model.Repository

@Composable
fun ReposList(
    header: @Composable () -> Unit,
    reposList: List<Repository>,
) {
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item { header() }
            items(reposList) { repo ->
                ReposListItem(repo = repo)
            }
        }
    }
}