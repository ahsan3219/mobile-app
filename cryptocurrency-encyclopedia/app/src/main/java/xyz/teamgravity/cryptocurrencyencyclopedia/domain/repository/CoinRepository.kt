package xyz.teamgravity.cryptocurrencyencyclopedia.domain.repository

import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.CoinDetailDto
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoin(coinId: String): CoinDetailDto
}