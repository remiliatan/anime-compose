package com.example.animelist.ui.components.materials

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun ImageView(
    imageUrl: Any?,
    modifier: Modifier = Modifier
){
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl ?: "")
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = modifier.clip(RoundedCornerShape(10)),
        contentScale = ContentScale.Crop
    )
}