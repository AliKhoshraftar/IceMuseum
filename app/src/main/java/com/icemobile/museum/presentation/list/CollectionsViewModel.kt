package com.icemobile.museum.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icemobile.museum.common.Constants.PAGE_SIZE
import com.icemobile.museum.common.Response
import com.icemobile.museum.domain.model.collection.list.ArtObject
import com.icemobile.museum.domain.usecase.get_collections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val useCase: GetCollectionsUseCase
) : ViewModel() {

    val arts: MutableState<List<ArtObject>> = mutableStateOf(ArrayList())

    val query = mutableStateOf("")

    val loading = mutableStateOf(false)

    val page = mutableStateOf(1)

    var artListScrollPosition = 0

//    private val _state = mutableStateOf(CollectionsState())
//    val state: State<CollectionsState> = _state

    init {
        newSearch()
    }

    fun newSearch() {
        resetSearchState()
        useCase.execute(1, query.value).onEach {
            when (it) {
                is Response.Error -> {

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
            Timber.d("nextPage: triggered: " + page.value)
            if (page.value > 1) {
                useCase.execute(page.value, query.value).onEach {
                    when (it) {
                        is Response.Error -> {

                        }
                        is Response.Loading -> {
                            loading.value = true
                        }
                        is Response.Success -> {
                            Timber.d("search: appending")
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

    fun onChangeartscrollPosition(position: Int) {
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
        onChangeartscrollPosition(0)
    }
}