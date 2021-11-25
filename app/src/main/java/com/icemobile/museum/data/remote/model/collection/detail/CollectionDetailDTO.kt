package com.icemobile.museum.data.remote.model.collection.detail


import androidx.annotation.Keep
import com.icemobile.museum.domain.model.collection.detail.CollectionDetail

@Keep
data class CollectionDetailDTO(
    val elapsedMilliseconds: Int,
    val artObject: ArtObjectDetailDTO
)

fun CollectionDetailDTO.toCollectionDetail() = CollectionDetail(
    artObject = artObject.toArtObjectDetail()
)