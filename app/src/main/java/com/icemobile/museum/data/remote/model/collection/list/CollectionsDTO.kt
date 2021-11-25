package com.icemobile.museum.data.remote.model.collection.list


import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.icemobile.museum.domain.model.collection.list.Collections

@Keep
data class CollectionsDTO(
    @SerializedName("elapsedMilliseconds")
    val elapsedMilliseconds: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("countFacets")
    val countFacets: CountFacets,
    @SerializedName("artObjects")
    val artObjects: List<ArtObjectDTO>,
    @SerializedName("facets")
    val facets: List<Facet>
)

fun CollectionsDTO.toCollections() = Collections(
    count = count,
    artObjects = artObjects.map { it.toArtObject() },
)