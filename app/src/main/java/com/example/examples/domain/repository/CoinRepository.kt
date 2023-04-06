package com.example.examples.domain.repository

import com.example.examples.data.remote.dto.CoinDetailDto
import com.example.examples.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coindId: String): CoinDetailDto
}