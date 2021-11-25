package com.icemobile.museum.domain.usecase.get_collection_detail

import com.icemobile.museum.common.Response
import com.icemobile.museum.data.remote.model.collection.detail.toCollectionDetail
import com.icemobile.museum.data.remote.model.collection.list.toCollections
import com.icemobile.museum.domain.model.collection.detail.ArtObjectDetail
import com.icemobile.museum.domain.model.collection.detail.CollectionDetail
import com.icemobile.museum.domain.model.collection.list.Collections
import com.icemobile.museum.domain.repository.CollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCollectionDetailUseCase @Inject constructor(
    private val collectionRepository: CollectionRepository
) {
    fun execute(objectNumber: String): Flow<Response<CollectionDetail>> = flow {
        try {
            emit(Response.Loading())
            val coins = collectionRepository.getCollectionDetail(objectNumber).toCollectionDetail()
            emit(Response.Success(coins))
        } catch (e: HttpException) {
            emit(Response.Error(message = if (e.message != null) e.message else "An Unexpected problem occurred"))
        } catch (e: IOException) {
            emit(Response.Error(message = if (e.message != null) e.message else "Please Check your internet connectivity"))
        }
    }
}