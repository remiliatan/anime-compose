package com.example.animelist.ui.navigation

import kotlinx.serialization.Serializable

sealed class Screen(val route:String, val title: String = "", showBack: Boolean = false){
    @Serializable
    data object Home: Screen("home", "Anime Terbaru")

    @Serializable
    data object Detail: Screen("detail", "Detail Anime", showBack = true)
}