package ir.businesscard.bcard.data.remote.retrofit

import ir.businesscard.bcard.data.remote.dto.coin.CoinDTO
import ir.businesscard.bcard.data.remote.dto.coin.CoinDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinRetrofitService {

    @GET("coins")
    suspend fun getCoins(): List<CoinDTO>

    @GET("coins/{coin_id}")
    suspend fun getCoin(@Path("coin_id") coinId: String): CoinDetailDTO

}