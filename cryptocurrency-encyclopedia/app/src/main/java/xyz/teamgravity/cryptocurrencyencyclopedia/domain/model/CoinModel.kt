package xyz.teamgravity.cryptocurrencyencyclopedia.domain.model

data class CoinModel(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
