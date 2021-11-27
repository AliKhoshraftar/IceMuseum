package com.icemobile.museum.presentation.detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.icemobile.museum.common.Constants
import com.icemobile.museum.common.Constants.EMPTY
import com.icemobile.museum.common.Response
import com.icemobile.museum.domain.model.collection.detail.CollectionDetail
import com.icemobile.museum.domain.usecase.get_collection_detail.GetCollectionDetailUseCase
import com.icemobile.museum.presentation.util.FakeData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    private val useCase: GetCollectionDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CollectionDetailState())
    val state: State<CollectionDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COLLECTION_ID)?.let { objectNumber ->
            getCollectionDetail(objectNumber)
        }
    }

    private fun getCollectionDetail(objectNumber: String = EMPTY) {
        useCase.execute(objectNumber).onEach {
            when (it) {
                is Response.Error -> {
                    _state.value = CollectionDetailState(
                        collection = CollectionDetail(
                            FakeData.getFakeArt(objectNumber)
                        )
                    )
//                    _state.value =
//                        CollectionDetailState(error = it.message ?: "An unexpected error occurred")
                }
                is Response.Loading -> {
                    _state.value = CollectionDetailState(isLoading = true)
                }
                is Response.Success -> {
                    _state.value =
                        CollectionDetailState(collection = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}