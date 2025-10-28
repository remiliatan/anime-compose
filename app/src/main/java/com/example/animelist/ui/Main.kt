package com.example.animelist.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.animelist.ui.navigation.AppNavigation
import com.example.animelist.ui.theme.AnimeListTheme

@Preview(showBackground = true)
@Composable
fun Main(){
    AnimeListTheme {
        AppNavigation()
    }
}