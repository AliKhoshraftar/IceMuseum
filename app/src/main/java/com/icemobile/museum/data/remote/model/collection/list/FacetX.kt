package com.icemobile.museum.data.remote.model.collection.list


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class FacetX(
    @SerializedName("key")
    val key: String,
    @SerializedName("value")
    val value: Int
)