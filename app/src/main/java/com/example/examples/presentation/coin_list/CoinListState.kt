package com.example.examples.presentation.coin_list

import com.example.examples.domain.model.Coin

data class CoinListState(
    val istLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
