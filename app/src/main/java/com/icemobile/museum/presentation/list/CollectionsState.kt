package com.icemobile.museum.presentation.main

import com.icemobile.museum.domain.model.collection.list.Collections

data class CollectionsState(
    val isLoading: Boolean = false,
    val collections: Collections? = null,
    val error: String = ""
)
