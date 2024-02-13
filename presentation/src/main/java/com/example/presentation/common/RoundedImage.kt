package com.example.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.rememberImagePainter
import coil.request.CachePolicy
import coil.transform.CircleCropTransformation
import com.example.presentation.R

@Composable
fun RoundedImage(
    url: String,
    modifier: Modifier,
    contentDescription: String
) {

    Image(
        painter = rememberImagePainter(
            data = url,
            builder = {
                crossfade(true)
                transformations(CircleCropTransformation())
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .diskCachePolicy(CachePolicy.ENABLED)
                    .memoryCachePolicy(CachePolicy.ENABLED)
                    .memoryCacheKey(url)
            }
        ),
        contentDescription = contentDescription,
        modifier = modifier
    )

}