package com.icemobile.museum.data.repository

import com.icemobile.museum.data.remote.model.collection.list.CollectionsDTO
import com.icemobile.museum.data.remote.retrofit.CollectionRetrofitService
import com.icemobile.museum.domain.repository.CollectionRepository
import javax.inject.Inject

class CollectionRepositoryImpl @Inject constructor(
    private val collectionRetrofitService: CollectionRetrofitService
) : CollectionRepository {

    override suspend fun getCollections(): CollectionsDTO {
        return collectionRetrofitService.getCollections()
    }

}