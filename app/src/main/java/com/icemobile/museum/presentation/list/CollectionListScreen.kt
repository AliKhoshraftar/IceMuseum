package com.icemobile.museum.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.icemobile.museum.common.Constants.PAGE_SIZE
import com.icemobile.museum.presentation.Screen
import com.icemobile.museum.presentation.list.components.CollectionListItem
import com.icemobile.museum.presentation.ui.component.SearchAppBar
import kotlinx.coroutines.launch

@ExperimentalComposeUiApi
@Composable
fun CollectionListScreen(
    navController: NavController,
    viewModel: CollectionsViewModel = hiltViewModel(),
) {

    val arts = viewModel.arts.value
    val query = viewModel.query.value
    val loading = viewModel.loading.value
    val page = viewModel.page.value
    val scaffoldState = rememberScaffoldState()
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
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
        snackbarHost = {
            scaffoldState.snackbarHostState
        },

        ) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = listState
            ) {
                itemsIndexed(arts) { index, art ->
                    viewModel.onChangeartscrollPosition(index)
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
//        if (state.error.isNotBlank()) {
//            Text(
//                text = state.error,
//                color = MaterialTheme.colors.error,
//                textAlign = TextAlign.Center,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 20.dp)
//                    .align(Alignment.Center)
//            )
//        }
            if (loading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}