package com.icemobile.museum.presentation.ui.screen

sealed class Screen(val route: String) {
    object CollectionListScreen : Screen("collection_list_screen")
    object CollectionDetailScreen : Screen("collection_detail_screen")
}
