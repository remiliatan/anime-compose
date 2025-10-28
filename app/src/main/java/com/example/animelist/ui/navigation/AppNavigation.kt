package com.example.animelist.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.animelist.ui.screens.DetailScreen
import com.example.animelist.ui.screens.HomeScreen

@Composable
fun AppNavigation (){
    val listNav = rememberNavController()
    NavHost(listNav, "home"){
        composable(Screen.Home.route){
            HomeScreen(listNav)
        }
        composable(Screen.Detail.route){
            DetailScreen(listNav)
        }
    }
}