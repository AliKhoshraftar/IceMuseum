package com.icemobile.museum.data.remote.model.collection.list


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.icemobile.museum.data.remote.model.collection.share.WebImage
import com.icemobile.museum.domain.model.collection.list.ArtObject

@Keep
data class ArtObjectDTO(
    @SerializedName("id")
    val id: String,
    @SerializedName("links")
    val links: Links,
    @SerializedName("objectNumber")
    val objectNumber: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("hasImage")
    val hasImage: Boolean,
    @SerializedName("principalOrFirstMaker")
    val principalOrFirstMaker: String,
    @SerializedName("longTitle")
    val longTitle: String,
    @SerializedName("showImage")
    val showImage: Boolean,
    @SerializedName("permitDownload")
    val permitDownload: Boolean,
    @SerializedName("webImage")
    val webImage: WebImage,
    @SerializedName("headerImage")
    val headerImage: HeaderImage,
    @SerializedName("productionPlaces")
    val productionPlaces: List<String>
)

fun ArtObjectDTO.toArtObject() = ArtObject(
    id = id,
    links = links,
    objectNumber = objectNumber,
    title = title,
    hasImage = hasImage,
    principalOrFirstMaker = principalOrFirstMaker,
    headerImage = headerImage,
    // TODO Bellow parameters added to this model according to the problem with detail API
    longTitle = longTitle,
    webImage = webImage,
    description = longTitle.repeat(20)
)