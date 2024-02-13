package com.example.presentation.users.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.example.domain.model.User
import com.example.presentation.R
import com.example.presentation.common.RoundedImage

@Composable
fun UsersListItem(
    user: User,
    onItemClick: (User) -> Unit
) {
    val paddingXXSmall = dimensionResource(id = R.dimen.padding_xxsmall)
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(user)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            RoundedImage(
                url = user.avatarUrl,
                modifier = Modifier
                    .size(50.dp)
                    .padding(end = paddingMedium),
                contentDescription = ""
            )
            Column {
                Text(
                    text = user.userId,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.size(paddingXXSmall))

                Text(
                    text = user.htmlUrl,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Divider(
            Modifier.padding(end = paddingMedium)
        )
    }
}