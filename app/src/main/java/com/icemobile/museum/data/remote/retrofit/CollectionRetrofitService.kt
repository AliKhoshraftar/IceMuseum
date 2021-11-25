package com.icemobile.museum.data.remote.retrofit

import com.icemobile.museum.data.remote.common.Culture
import com.icemobile.museum.data.remote.model.collection.list.CollectionsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CollectionRetrofitService {

    @GET("{culture}/collection")
    suspend fun getCollections(
        @Path("culture") culture: String = Culture.ENGLISH.code,
        @Query("p") page: Int
    ): CollectionsDTO

//    @GET("{culture}/collection/{object-number}")
//    suspend fun getCoin(@Path("coin_id") coinId: String): CoinDetailDTO

}