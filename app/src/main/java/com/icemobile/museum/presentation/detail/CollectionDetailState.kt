package com.icemobile.museum.presentation.detail

import com.icemobile.museum.domain.model.collection.detail.CollectionDetail

data class CollectionDetailState(
    val isLoading: Boolean = false,
    val collection: CollectionDetail? = null,
    val error: String = ""
)
