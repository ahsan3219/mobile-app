package xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto


import com.google.gson.annotations.SerializedName
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.model.CoinModel

data class CoinDto(
    @SerializedName("id") val id: String,
    @SerializedName("is_active") val isActive: Boolean,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("name") val name: String,
    @SerializedName("rank") val rank: Int,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("type") val type: String
)

fun CoinDto.toCoin(): CoinModel {
    return CoinModel(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}