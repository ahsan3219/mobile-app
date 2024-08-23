package xyz.teamgravity.cryptocurrencyencyclopedia.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import xyz.teamgravity.cryptocurrencyencyclopedia.common.Const
import xyz.teamgravity.cryptocurrencyencyclopedia.presentation.coin_detail.components.CoinDetailScreen
import xyz.teamgravity.cryptocurrencyencyclopedia.presentation.coin_list.components.CoinListScreen
import xyz.teamgravity.cryptocurrencyencyclopedia.presentation.ui.theme.CryptocurrencyEncyclopediaTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyEncyclopediaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }

                        composable(route = Screen.CoinDetailScreen.route + "/{${Const.PARAM_COIN_ID}}") {
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}
