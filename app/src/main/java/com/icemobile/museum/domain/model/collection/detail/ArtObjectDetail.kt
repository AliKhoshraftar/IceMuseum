package com.icemobile.museum.domain.model.collection.detail


import androidx.annotation.Keep
import com.icemobile.museum.data.remote.model.collection.detail.Links
import com.icemobile.museum.data.remote.model.collection.share.WebImage

@Keep
data class ArtObjectDetail(
    val id: String,
    val links: Links,
    val objectNumber: String,
    val title: String,
    val description: String,
    val hasImage: Boolean,
    val principalOrFirstMaker: String,
    val longTitle: String,
    val webImage: WebImage
)