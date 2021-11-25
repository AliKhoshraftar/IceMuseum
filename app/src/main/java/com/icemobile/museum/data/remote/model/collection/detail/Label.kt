package com.icemobile.museum.data.remote.model.collection.detail


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Label(
    @SerializedName("title")
    val title: String,
    @SerializedName("makerLine")
    val makerLine: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("notes")
    val notes: String,
    @SerializedName("date")
    val date: String
)