package xyz.teamgravity.cryptocurrencyencyclopedia.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import xyz.teamgravity.cryptocurrencyencyclopedia.common.Const
import xyz.teamgravity.cryptocurrencyencyclopedia.common.Resource
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.use_case.get_coin.GetCoinUseCase
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Const.PARAM_COIN_ID)?.let {
            getCoin(it)
        }
    }

    private fun getCoin(id: String) {
        getCoinUseCase(id).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinDetailState(coin = result.data)
                }

                is Resource.Error -> {
                    _state.value = CoinDetailState(error = result.message ?: "Unknown error occurred")
                }

                is Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}