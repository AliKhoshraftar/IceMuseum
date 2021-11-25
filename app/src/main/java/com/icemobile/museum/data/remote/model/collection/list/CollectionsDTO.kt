package com.icemobile.museum.data.remote.model.collection.list


import androidx.annotation.Keep
import com.icemobile.museum.domain.model.collection.list.Collections

@Keep
data class CollectionsDTO(
    val elapsedMilliseconds: Int,
    val count: Int,
    val countFacets: CountFacets,
    val artObjects: List<ArtObjectDTO>,
    val facets: List<Facet>
)

fun CollectionsDTO.toCollections() = Collections(
    count = count,
    artObjects = artObjects.map { it.toArtObject() },
)