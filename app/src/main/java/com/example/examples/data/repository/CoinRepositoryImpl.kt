package com.example.examples.data.repository

import com.example.examples.data.remote.CoinPaprikaApi
import com.example.examples.data.remote.dto.CoinDetailDto
import com.example.examples.data.remote.dto.CoinDto
import com.example.examples.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coindId: String): CoinDetailDto {
        return api.getCoinById(coinId = coindId)
    }
}