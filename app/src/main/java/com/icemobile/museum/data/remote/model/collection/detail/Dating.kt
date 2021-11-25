package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Dating(
    @SerializedName("presentingDate")
    val presentingDate: String,
    @SerializedName("sortingDate")
    val sortingDate: Int,
    @SerializedName("period")
    val period: Int,
    @SerializedName("yearEarly")
    val yearEarly: Int,
    @SerializedName("yearLate")
    val yearLate: Int
)