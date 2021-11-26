package com.icemobile.museum.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.icemobile.museum.R
import com.icemobile.museum.domain.model.collection.list.ArtObject
import com.icemobile.museum.presentation.detail.CollectionDetailScreen
import com.icemobile.museum.presentation.list.CollectionListScreen
import com.icemobile.museum.presentation.ui.theme.MuseumAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @ExperimentalComposeUiApi
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
                            route = Screen.CollectionDetailScreen.route + "/{objectNumber}"
                        ) {
                            CollectionDetailScreen()
                        }
                    }
                }
            }
        }
    }
}