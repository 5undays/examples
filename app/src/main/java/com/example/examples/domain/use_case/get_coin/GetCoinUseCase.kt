package com.example.examples.domain.use_case.get_coin

import com.example.examples.common.Resource
import com.example.examples.data.remote.dto.toCoin
import com.example.examples.data.remote.dto.toCoinDetail
import com.example.examples.domain.model.Coin
import com.example.examples.domain.model.CoinDetail
import com.example.examples.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(coinId : String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Expected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. check your intract internet"))
        }
    }
}