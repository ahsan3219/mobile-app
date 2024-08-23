package xyz.teamgravity.cryptocurrencyencyclopedia.presentation.coin_list

import xyz.teamgravity.cryptocurrencyencyclopedia.domain.model.CoinModel

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinModel> = emptyList(),
    val error: String = ""
)
