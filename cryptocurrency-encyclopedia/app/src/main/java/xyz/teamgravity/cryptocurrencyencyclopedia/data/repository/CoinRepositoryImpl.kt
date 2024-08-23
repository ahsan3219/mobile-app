package xyz.teamgravity.cryptocurrencyencyclopedia.data.repository

import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.CoinPaprikaApi
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.CoinDetailDto
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.CoinDto
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val api: CoinPaprikaApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoin(coinId: String): CoinDetailDto {
        return api.getCoin(coinId)
    }
}