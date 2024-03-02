package com.example.beersapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.beersapp.ui.screens.HomeScreen
import com.example.beersapp.ui.viewmodels.BeersViewModel

@Composable
fun AppNavigation (navController: NavHostController) {

    val beersViewModel : BeersViewModel = viewModel()

    NavHost (navController = navController, startDestination = "home") {
        composable (route = "home") {
            HomeScreen(beersViewModel)
        }
    }
}