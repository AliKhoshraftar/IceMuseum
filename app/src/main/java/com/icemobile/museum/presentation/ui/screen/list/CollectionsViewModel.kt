package com.icemobile.museum.presentation.ui.screen.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icemobile.museum.common.Constants.EMPTY
import com.icemobile.museum.common.Constants.PAGE_SIZE
import com.icemobile.museum.common.Response
import com.icemobile.museum.domain.model.collection.list.ArtObject
import com.icemobile.museum.domain.usecase.get_collections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val useCase: GetCollectionsUseCase
) : ViewModel() {

    val arts: MutableState<List<ArtObject>> = mutableStateOf(ArrayList())
    val query = mutableStateOf(EMPTY)
    val error = mutableStateOf(EMPTY)
    val loading = mutableStateOf(false)
    val page = mutableStateOf(1)
    var artListScrollPosition = 0

    init {
        newSearch()
    }

    fun newSearch() {
        resetSearchState()
        useCase.execute(1, query.value).onEach {
            when (it) {
                is Response.Error -> {
                    error.value = it.message ?: "Unexpected Error Occurred"
                    loading.value = false
                }
                is Response.Loading -> {
                    loading.value = true
                }
                is Response.Success -> {
                    arts.value = it.data?.artObjects ?: emptyList()
                    loading.value = false
                }
            }
        }.launchIn(viewModelScope)
    }

    fun nextPage() {
        if ((artListScrollPosition + 1) >= (page.value * PAGE_SIZE)) {
            loading.value = true
            incrementPage()
            if (page.value > 1) {
                useCase.execute(page.value, query.value).onEach {
                    when (it) {
                        is Response.Error -> {
                            error.value = it.message ?: "No more data available"
                            loading.value = false
                        }
                        is Response.Loading -> {
                            loading.value = true
                        }
                        is Response.Success -> {
                            appendArts(it.data?.artObjects ?: emptyList())
                            loading.value = false
                        }
                    }
                }.launchIn(viewModelScope)
            }
        }
    }

    /**
     * Append new arts to the current list of arts
     */
    private fun appendArts(arts: List<ArtObject>) {
        val current = ArrayList(this.arts.value)
        current.addAll(arts)
        this.arts.value = current
    }

    private fun incrementPage() {
        page.value = page.value + 1
    }

    fun onChangeArtScrollPosition(position: Int) {
        artListScrollPosition = position
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }

    /**
     * Called when a new search is executed.
     */
    private fun resetSearchState() {
        arts.value = listOf()
        page.value = 1
        onChangeArtScrollPosition(0)
    }
}