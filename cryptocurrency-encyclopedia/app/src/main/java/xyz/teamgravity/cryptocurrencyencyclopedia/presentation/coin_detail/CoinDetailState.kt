package xyz.teamgravity.cryptocurrencyencyclopedia.presentation.coin_detail

import xyz.teamgravity.cryptocurrencyencyclopedia.domain.model.CoinDetailModel
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.model.CoinModel

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetailModel? = null,
    val error: String = ""
)
