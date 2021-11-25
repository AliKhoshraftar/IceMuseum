package com.icemobile.museum.data.remote.model.collection.list


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep

@Keep
data class CollectionsResponse(
    @SerializedName("elapsedMilliseconds")
    val elapsedMilliseconds: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("countFacets")
    val countFacets: CountFacets,
    @SerializedName("artObjects")
    val artObjects: List<ArtObject>,
    @SerializedName("facets")
    val facets: List<Facet>
)