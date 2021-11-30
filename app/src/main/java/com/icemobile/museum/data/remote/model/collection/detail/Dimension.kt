package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Dimension(
    val unit: String,
    val type: String,
    val part: Any?,
    val value: String
)