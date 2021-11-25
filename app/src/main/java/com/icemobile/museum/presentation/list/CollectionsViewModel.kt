package com.icemobile.museum.presentation.list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.*
import com.icemobile.museum.common.Response
import com.icemobile.museum.domain.model.collection.list.Collections
import com.icemobile.museum.domain.usecase.get_collections.GetCollectionsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CollectionsViewModel @Inject constructor(
    private val useCase: GetCollectionsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CollectionsState())
    val state: State<CollectionsState> = _state

    init {
        getCollections(1)
    }

    fun getCollections(page: Int = 1) {
        useCase.execute(page).onEach {
            when (it) {
                is Response.Error -> {
                    _state.value =
                        CollectionsState(error = it.message ?: "An unexpected error occurred")
                }
                is Response.Loading -> {
                    _state.value = (CollectionsState(isLoading = true))
                }
                is Response.Success -> {
                    _state.value =
                        (CollectionsState(collections = it.data ?: Collections(0, emptyList())))
                }
            }
        }.launchIn(viewModelScope)
    }
}