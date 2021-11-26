package com.icemobile.museum.domain.usecase.get_collections

import com.icemobile.museum.common.Response
import com.icemobile.museum.data.remote.model.collection.list.toCollections
import com.icemobile.museum.domain.model.collection.list.Collections
import com.icemobile.museum.domain.repository.CollectionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCollectionsUseCase @Inject constructor(
    private val collectionRepository: CollectionRepository
) {
    fun execute(page: Int, query: String): Flow<Response<Collections>> = flow {
        try {
            emit(Response.Loading())
            val coins = collectionRepository.getCollections(page, query).toCollections()
            emit(Response.Success(coins))
        } catch (e: HttpException) {
            emit(Response.Error(message = if (e.message != null) e.message else "An Unexpected problem occurred"))
        } catch (e: IOException) {
            emit(Response.Error(message = if (e.message != null) e.message else "Please Check your internet connectivity"))
        }
    }
}