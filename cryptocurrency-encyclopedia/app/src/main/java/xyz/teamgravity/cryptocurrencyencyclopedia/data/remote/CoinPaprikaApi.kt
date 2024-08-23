package xyz.teamgravity.cryptocurrencyencyclopedia.data.remote

import retrofit2.http.GET
import retrofit2.http.Path
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.CoinDetailDto
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.CoinDto

interface CoinPaprikaApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coin_id}")
    suspend fun getCoin(@Path("coin_id") coinId: String): CoinDetailDto
}