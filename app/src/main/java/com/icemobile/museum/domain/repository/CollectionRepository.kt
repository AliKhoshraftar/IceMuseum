package ir.businesscard.bcard.domain.repository

import ir.businesscard.bcard.data.remote.dto.coin.CoinDTO
import ir.businesscard.bcard.data.remote.dto.coin.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>
    suspend fun getCoinDetail(coinId: String): CoinDetailDTO
}