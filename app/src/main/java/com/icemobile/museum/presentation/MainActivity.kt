package com.icemobile.museum.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.icemobile.museum.R
import com.icemobile.museum.presentation.detail.CollectionDetailScreen
import com.icemobile.museum.presentation.list.CollectionListScreen
import com.icemobile.museum.presentation.ui.theme.MuseumAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuseumAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CollectionListScreen.route
                    ) {

                        // List Screen
                        composable(
                            route = Screen.CollectionListScreen.route
                        ) {
                            CollectionListScreen(navController)
                        }

                        // Collection Detail Screen
                        composable(
                            route = Screen.CollectionDetailScreen.route + "/{collectionId}"
                        ) {
                            CollectionDetailScreen()
                        }
                    }
                }
            }
        }
    }
}