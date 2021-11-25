package com.icemobile.museum.domain.model.collection.list


import androidx.annotation.Keep

@Keep
data class Collections(
    val count: Int,
    val artObjects: List<ArtObject>,
)