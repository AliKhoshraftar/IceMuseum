package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Dimension(
    @SerializedName("unit")
    val unit: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("part")
    val part: Any?,
    @SerializedName("value")
    val value: String
)