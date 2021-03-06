package com.icemobile.museum.data.remote.model.collection.list


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class Facet(
    @SerializedName("facets")
    val facets: List<FacetX>,
    @SerializedName("name")
    val name: String,
    @SerializedName("otherTerms")
    val otherTerms: Int,
    @SerializedName("prettyName")
    val prettyName: Int
)