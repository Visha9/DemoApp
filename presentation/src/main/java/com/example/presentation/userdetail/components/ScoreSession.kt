package com.example.presentation.userdetail.components

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
import com.example.domain.model.UserDetailDomainModel
import com.example.presentation.R
import com.example.presentation.common.RoundedImage


@Composable
fun ScoreSession(userDetail: UserDetailDomainModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        RoundedImage(
            url =  userDetail.avatarUrl,
           modifier = Modifier
                .size(dimensionResource(id = R.dimen.avatar_size_large))
                .padding(
                    end = dimensionResource(id = R.dimen.padding_medium)
                ),
            contentDescription = ""
        )
        ScoreItem(count = userDetail.publicRepos, description = stringResource(R.string.repos_score_title))
        ScoreItem(count = userDetail.followers, description = stringResource(R.string.followers_score_title))
        ScoreItem(count = userDetail.following, description = stringResource(R.string.following_score_title))
    }


}