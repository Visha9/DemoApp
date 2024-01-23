package com.example.githubapp.presentation.userdetail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.githubapp.R
import com.example.githubapp.data.model.UserDetail


@Composable
fun ScoreSession(userDetail: UserDetail) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Image(painter = rememberImagePainter(
            data = userDetail.avatarUrl,
            builder = {
                crossfade(true)
                transformations(CircleCropTransformation())
                    .placeholder(R.drawable.ic_launcher_foreground)
            }
        ) , contentDescription = "",
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.avatar_size_large))
                .padding(
                    end = dimensionResource(id = R.dimen.padding_medium)
                ))


        ScoreItem(count = userDetail.publicRepos, description = stringResource(R.string.repos_score_title))
        ScoreItem(count = userDetail.followers, description = stringResource(R.string.followers_score_title))
        ScoreItem(count = userDetail.following, description = stringResource(R.string.following_score_title))
    }


}