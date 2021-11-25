package com.icemobile.museum.data.remote.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Links(
    @SerializedName("self")
    val self: String,
    @SerializedName("web")
    val web: String
)