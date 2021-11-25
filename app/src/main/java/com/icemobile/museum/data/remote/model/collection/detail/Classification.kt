package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Classification(
    @SerializedName("iconClassIdentifier")
    val iconClassIdentifier: List<String>
)