package com.example.githubapp.presentation.userdetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.githubapp.R
import com.example.githubapp.data.model.Repository
import java.util.Locale

@Composable
fun ReposListItem(repo: Repository) {
    val paddingXXSmall = dimensionResource(id = R.dimen.padding_xxsmall)
    val paddingSmall = dimensionResource(id = R.dimen.padding_small)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)


    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingMedium)
        ) {
            Column {
                Text(
                    text = repo.name,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(paddingXXSmall))

                Text(
                    text = repo.description ?: stringResource(R.string.no_description_informed),
                     modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(paddingSmall))

                Text(
                    text = repo.language?.uppercase(Locale.getDefault())
                        ?: stringResource(R.string.language_not_defined),
                )

                Spacer(modifier = Modifier.size(paddingMedium))

                CounterSession(repo = repo)
            }
        }
        Divider()
    }
}

@Composable
fun CounterSession(repo: Repository) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        CounterItem(icon = Icons.Outlined.Favorite, counterText = repo.watchersCount.toString())
        CounterItem(icon = Icons.Outlined.Favorite, counterText = repo.stargazersCount.toString())
        CounterItem(icon = Icons.Outlined.Info, counterText = repo.forksCount.toString())
    }
}

@Composable
fun CounterItem(
    icon: ImageVector,
    counterText: String
) {
    Icon(
        imageVector = icon,
        contentDescription = null
    )
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_xsmall)))
    Text(
        text = counterText
    )
    Spacer(modifier = Modifier.size(dimensionResource(id = R.dimen.padding_small)))
}