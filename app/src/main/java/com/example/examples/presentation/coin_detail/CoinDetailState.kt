package com.example.examples.presentation.coin_detail

import com.example.examples.domain.model.CoinDetail

data class CoinDetailState(
    val istLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
