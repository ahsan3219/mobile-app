package xyz.teamgravity.cryptocurrencyencyclopedia.domain.use_case.get_coins

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import xyz.teamgravity.cryptocurrencyencyclopedia.common.Resource
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.toCoin
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.model.CoinModel
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.repository.CoinRepository

class GetCoinsUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(): Flow<Resource<List<CoinModel>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}