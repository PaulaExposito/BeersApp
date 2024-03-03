package com.example.beersapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.beersapp.ui.navigation.AppNavigation
import com.example.beersapp.ui.theme.BeersAppTheme
import com.example.beersapp.ui.viewmodels.BeersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeersAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val beersViewModel : BeersViewModel by viewModels<BeersViewModel>()
                    val navController = rememberNavController()
                    AppNavigation(navController = navController, beersViewModel = beersViewModel)
                }
            }
        }
    }
}
