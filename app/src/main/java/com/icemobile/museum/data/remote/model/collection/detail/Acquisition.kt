package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Acquisition(
    @SerializedName("method")
    val method: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("creditLine")
    val creditLine: String
)