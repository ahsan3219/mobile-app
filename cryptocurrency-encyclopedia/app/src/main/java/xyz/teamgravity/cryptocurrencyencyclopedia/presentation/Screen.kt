package xyz.teamgravity.cryptocurrencyencyclopedia.presentation

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list")
    object CoinDetailScreen : Screen("coin_detail")
}
