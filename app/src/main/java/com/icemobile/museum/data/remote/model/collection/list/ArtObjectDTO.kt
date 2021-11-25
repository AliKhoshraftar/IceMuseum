package com.icemobile.museum.data.remote.model.collection.list


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class ArtObject(
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