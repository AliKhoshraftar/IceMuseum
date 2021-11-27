package com.icemobile.museum.data.repository

import com.icemobile.museum.data.remote.model.collection.detail.CollectionDetailDTO
import com.icemobile.museum.data.remote.model.collection.list.CollectionsDTO
import com.icemobile.museum.domain.repository.CollectionRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class FakeCollectionRepository : CollectionRepository {

    lateinit var fakeCollections: CollectionsDTO
    lateinit var fakeCollectionDetail: CollectionDetailDTO

    private var isNetworkError = false
    private var isServerError = false

    fun setIsNetworkError(networkError: Boolean) {
        isNetworkError = networkError
    }

    fun setIsServerError(serverError: Boolean) {
        isServerError = serverError
    }

    override suspend fun getCollections(page: Int, query: String): CollectionsDTO {
        when {
            isNetworkError -> {
                throw IOException("Check Internet Connection")
            }
            isServerError -> {
                throw HttpException(
                    Response.error<CollectionsDTO>(
                        500,
                        "{\"key\":[\"somestuff\"]}"
                            .toResponseBody("application/json".toMediaTypeOrNull())
                    )
                )
            }
            else -> {
                return fakeCollections
            }
        }
    }

    override suspend fun getCollectionDetail(objectNumber: String): CollectionDetailDTO {
        when {
            isNetworkError -> {
                throw IOException("Check Internet Connection")
            }
            isServerError -> {
                throw HttpException(
                    Response.error<CollectionsDTO>(
                        500,
                        "{\"key\":[\"somestuff\"]}"
                            .toResponseBody("application/json".toMediaTypeOrNull())
                    )
                )
            }
            else -> {
                return fakeCollectionDetail
            }
        }
    }
}