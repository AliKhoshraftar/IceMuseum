package com.icemobile.museum.data.remote.model.collection.detail


import androidx.annotation.Keep

@Keep
data class Dating(
    val presentingDate: String,
    val sortingDate: Int,
    val period: Int,
    val yearEarly: Int,
    val yearLate: Int
)