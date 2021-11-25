package ir.businesscard.bcard.domain.use_case.get_coin

import ir.businesscard.bcard.common.Response
import ir.businesscard.bcard.data.remote.dto.coin.CoinDTO
import ir.businesscard.bcard.data.remote.dto.coin.toCoin
import ir.businesscard.bcard.domain.model.coins.Coin
import ir.businesscard.bcard.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val coinRepository: CoinRepository
) {
    fun execute(): Flow<Response<List<Coin>>> = flow {
        try {
            emit(Response.Loading())
            val coins = coinRepository.getCoins().map { it.toCoin() }
            emit(Response.Success(coins))
        } catch (e: HttpException) {
            emit(Response.Error(message = if (e.message != null) e.message else "An Unexpected problem occurred"))
        } catch (e: IOException) {
            emit(Response.Error(message = if (e.message != null) e.message else "Please Check your internet connectivity"))
        }
    }
}