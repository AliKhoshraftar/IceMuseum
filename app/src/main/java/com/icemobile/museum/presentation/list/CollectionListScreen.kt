package com.icemobile.museum.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.icemobile.museum.common.Constants.PAGE_SIZE
import com.icemobile.museum.presentation.Screen
import com.icemobile.museum.presentation.list.components.CollectionListItem
import com.icemobile.museum.presentation.ui.component.SearchAppBar

@ExperimentalComposeUiApi
@Composable
fun CollectionListScreen(
    navController: NavController,
    viewModel: CollectionsViewModel = hiltViewModel()
) {

    val arts = viewModel.arts.value
    val query = viewModel.query.value
    val error = viewModel.error.value
    val loading = viewModel.loading.value
    val page = viewModel.page.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            SearchAppBar(
                query = query,
                onQueryChanged = viewModel::onQueryChanged,
                onExecuteSearch = {
                    viewModel.newSearch()
                },
            )
        },
        scaffoldState = scaffoldState,
        ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(arts) { index, art ->
                    viewModel.onChangeArtScrollPosition(index)
                    if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                        viewModel.nextPage()
                    }
                    CollectionListItem(
                        art = art,
                        onItemClick = {
                            navController.navigate(
                                Screen.CollectionDetailScreen.route + "/${art.objectNumber}"
                            )
                        }
                    )
                }
            }
            if (error.isNotBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (loading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}