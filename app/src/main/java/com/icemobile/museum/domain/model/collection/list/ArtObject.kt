package com.icemobile.museum.domain.model.collection.list


import androidx.annotation.Keep
import com.icemobile.museum.data.remote.model.collection.list.HeaderImage
import com.icemobile.museum.data.remote.model.collection.list.Links

@Keep
data class ArtObject(
    val id: String,
    val links: Links,
    val objectNumber: String,
    val title: String,
    val hasImage: Boolean,
    val principalOrFirstMaker: String,
    val headerImage: HeaderImage,
)