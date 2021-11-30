package com.icemobile.museum.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.icemobile.museum.R
import com.icemobile.museum.presentation.ui.screen.Screen
import com.icemobile.museum.presentation.ui.screen.detail.CollectionDetailScreen
import com.icemobile.museum.presentation.ui.screen.list.CollectionListScreen
import com.icemobile.museum.presentation.ui.theme.MuseumAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_Launcher)
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = isSystemInDarkTheme()

            SideEffect {
                systemUiController.setSystemBarsColor(Color.White, darkIcons = useDarkIcons)
            }
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