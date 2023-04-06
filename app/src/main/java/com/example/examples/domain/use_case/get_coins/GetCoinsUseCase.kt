package com.example.examples.domain.use_case.get_coins

import com.example.examples.common.Resource
import com.example.examples.data.remote.dto.toCoin
import com.example.examples.domain.model.Coin
import com.example.examples.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository: CoinRepository) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Expected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. check your intract internet"))
        }
    }
}