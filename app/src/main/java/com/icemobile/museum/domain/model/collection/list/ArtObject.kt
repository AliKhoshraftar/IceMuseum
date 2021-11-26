package com.icemobile.museum.domain.model.collection.list


import androidx.annotation.Keep
import com.icemobile.museum.data.remote.model.collection.list.HeaderImage
import com.icemobile.museum.data.remote.model.collection.list.Links
import com.icemobile.museum.data.remote.model.collection.share.WebImage
import com.icemobile.museum.domain.model.collection.detail.ArtObjectDetail

@Keep
data class ArtObject(
    val id: String,
    val links: Links,
    val objectNumber: String,
    val title: String,
    val hasImage: Boolean,
    val principalOrFirstMaker: String,
    val headerImage: HeaderImage,
    // Bellow parameters added to this model according to the problem with detail API
    val longTitle: String,
    val description: String,
    val webImage: WebImage?
)

fun ArtObject.toArtDetailObject() = ArtObjectDetail(
    id = id,
    objectNumber = objectNumber,
    title = title,
    description = description,
    hasImage = hasImage,
    principalOrFirstMaker = principalOrFirstMaker,
    longTitle = longTitle,
    webImage = webImage
)