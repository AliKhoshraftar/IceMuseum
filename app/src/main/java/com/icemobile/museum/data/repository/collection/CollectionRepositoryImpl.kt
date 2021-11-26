package com.icemobile.museum.data.repository.collection

import com.icemobile.museum.data.remote.model.collection.detail.CollectionDetailDTO
import com.icemobile.museum.data.remote.model.collection.list.CollectionsDTO
import com.icemobile.museum.data.remote.retrofit.CollectionRetrofitService
import com.icemobile.museum.domain.repository.CollectionRepository
import javax.inject.Inject

class CollectionRepositoryImpl @Inject constructor(
    private val collectionRetrofitService: CollectionRetrofitService
) : CollectionRepository {

    override suspend fun getCollections(page: Int, query: String): CollectionsDTO {
        return collectionRetrofitService.getCollections(page = page, query = query)
    }

    override suspend fun getCollectionDetail(objectNumber: String): CollectionDetailDTO {
        return collectionRetrofitService.getCollectionDetail(objectNumber = objectNumber)
    }

}