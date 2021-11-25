package com.icemobile.museum.presentation

sealed class Screen(val route: String) {
    object CollectionListScreen : Screen("collection_list_screen")
    object CollectionDetailScreen : Screen("collection_detail_screen")
}
