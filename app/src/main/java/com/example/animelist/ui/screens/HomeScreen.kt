package com.example.animelist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.animelist.model.AnimeModel
import com.example.animelist.ui.components.items.list.CardAnime
import com.example.animelist.ui.components.materials.TextView


@Composable
fun HomeScreen(navController:NavController){

    val animeModel = AnimeModel(
        imageUrl = "https://cdn.myanimelist.net/images/anime/1526/148873.webp",
        title = "One Piece no Tameni"
    )

    Scaffold { padding ->
        Column(
            modifier = Modifier.padding(padding),
        ) {
            Column(
                modifier = Modifier.padding(10.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ){
                TextView(
                    "Anime Terbaru",
                    isBold = true,
                    size = 20
                )
                Column{
                    LazyVerticalGrid (
                        columns = GridCells.Fixed(3),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ){
                        items((1..6).toList()){ item ->
                            CardAnime(
                                animeModel,
                                onClick = {
                                    println("Kamu klik ${animeModel.title}")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}