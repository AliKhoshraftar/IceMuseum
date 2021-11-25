package com.icemobile.museum.data.remote.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class HeaderImage(
    @SerializedName("guid")
    val guid: String,
    @SerializedName("offsetPercentageX")
    val offsetPercentageX: Int,
    @SerializedName("offsetPercentageY")
    val offsetPercentageY: Int,
    @SerializedName("width")
    val width: Int,
    @SerializedName("height")
    val height: Int,
    @SerializedName("url")
    val url: String
)