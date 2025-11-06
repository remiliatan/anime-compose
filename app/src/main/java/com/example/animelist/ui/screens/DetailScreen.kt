package com.example.animelist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animelist.ui.components.materials.HtmlText
import com.example.animelist.ui.components.materials.ImageView
import com.example.animelist.ui.components.materials.TextView
import com.example.animelist.ui.theme.FlatGreen

@Composable
fun DetailScreen(nav:NavController){
    Column(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            modifier = Modifier.height(150.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            ImageView(
                "https://s4.anilist.co/file/anilistcdn/media/anime/cover/small/bx182317-zzpOnAECrM2o.png",
                modifier = Modifier.fillMaxWidth(0.30f).fillMaxHeight(),
            )
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                TextView(
                    "Boku no Kokoro no Yabai Yatsu",
                    isBold = true,
                    size = 20,
                    maxLines = 4
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Rating",
                        tint = FlatGreen
                    )
                    TextView(
                        "7.9",
                        size = 18,
                        maxLines = 1
                    )
                }
            }
        }
        TextView(
            "Sinopsis",
            isBold = true,
            size = 18
        )
        HtmlText(
            html = "Fascinated by murder and all things macabre, Kyoutarou daydreams of acting out his twisted fantasies on his unsuspecting classmates — but an encounter with Anna Yamada, the gorgeous class idol, lights a spark in the darkness of his heart. It’s a classic tale of an antisocial boy falling for a popular girl, but neither are who they appear to be at first glance. Will Kyoutarou and Anna defy their expectations of each other — and of themselves?<br>\\n<br>\\n(Source: HIDIVE)"
        )
    }
}