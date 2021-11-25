package com.icemobile.museum.presentation.list

import com.icemobile.museum.domain.model.collection.list.Collections

data class CollectionsState(
    val isLoading: Boolean = false,
    val collections: Collections = Collections(0, emptyList()),
    val error: String = ""
)
