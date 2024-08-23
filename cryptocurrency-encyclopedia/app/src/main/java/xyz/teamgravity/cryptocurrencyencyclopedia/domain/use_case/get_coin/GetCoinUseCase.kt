package xyz.teamgravity.cryptocurrencyencyclopedia.domain.use_case.get_coin

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import xyz.teamgravity.cryptocurrencyencyclopedia.common.Resource
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.dto.toCoinDetail
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.model.CoinDetailModel
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.repository.CoinRepository

class GetCoinUseCase(
    private val repository: CoinRepository
) {

    operator fun invoke(id: String): Flow<Resource<CoinDetailModel>> = flow {
        try {
            emit(Resource.Loading())
            val coin = repository.getCoin(id).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unknown error occurred"))
        }
    }
}