package com.icemobile.museum.domain.repository

import com.icemobile.museum.data.remote.model.collection.detail.CollectionDetailDTO
import com.icemobile.museum.data.remote.model.collection.list.CollectionsDTO

interface CollectionRepository {
    suspend fun getCollections(page: Int): CollectionsDTO
    suspend fun getCollectionDetail(objectNumber: String): CollectionDetailDTO
}