package com.example.animelist.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.animelist.ui.components.items.list.CardAnime
import com.example.animelist.ui.components.materials.TextView
import com.example.animelist.utils.api.viewmodel.AnimeViewModel
import com.example.animelist.utils.helpers.rememberInfiniteScroll
import kotlinx.coroutines.delay


@Composable
fun HomeScreen(navController:NavController){
    val animeViewModel = viewModel<AnimeViewModel>()
    val isLoading by animeViewModel.isLoading
    val animes by animeViewModel.items

    val gridState = rememberLazyGridState()
    var searchText by remember { mutableStateOf("") }
    rememberInfiniteScroll(gridState) {
        animeViewModel.loadMore()
    }
    LaunchedEffect(searchText) {
        delay(500)
        animeViewModel.setSearchQuery(searchText)
    }

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
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { newValue ->
                        searchText = newValue
                    },
                    label = {TextView("Cari disini")},
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
                if(isLoading){
                    CircularProgressIndicator()
                }else{
                    Column{
                        LazyVerticalGrid(
                            state = gridState,
                            columns = GridCells.Fixed(3),
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalArrangement = Arrangement.spacedBy(16.dp)
                        ){
                            items((animes).toList()){ item ->
                                CardAnime(
                                    item,
                                    onClick = {
                                        println("Kamu klssik ${item.idMal}")
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}