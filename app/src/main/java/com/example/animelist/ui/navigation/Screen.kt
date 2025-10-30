package com.example.animelist.ui.navigation

import kotlinx.serialization.Serializable

sealed class Screen(val route:String){
    @Serializable
    data object Home: Screen("home")

    @Serializable
    data object Detail: Screen("detail")
}