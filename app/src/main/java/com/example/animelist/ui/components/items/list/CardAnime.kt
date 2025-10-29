package com.example.animelist.ui.components.items.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.animelist.model.AnimeModel
import com.example.animelist.ui.components.materials.ImageView
import com.example.animelist.ui.components.materials.TextView

@Composable
fun CardAnime(
    animeModel: AnimeModel,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit) ? = null
){
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable(enabled = onClick != null) {onClick?.invoke()},
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageView(animeModel.coverImage?.medium, modifier = Modifier.fillMaxWidth().height(150.dp))
        TextView(
            animeModel.title?.romaji ?: "",
            isBold = true,
            size = 16,
            maxLines = 2,
            modifier = Modifier.align(Alignment.Start)
        )
    }
}