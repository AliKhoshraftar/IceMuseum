package com.icemobile.museum.data.remote.model


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CountFacets(
    @SerializedName("hasimage")
    val hasimage: Int,
    @SerializedName("ondisplay")
    val ondisplay: Int
)