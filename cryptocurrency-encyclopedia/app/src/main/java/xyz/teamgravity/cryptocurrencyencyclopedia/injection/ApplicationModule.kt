package xyz.teamgravity.cryptocurrencyencyclopedia.injection

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.teamgravity.cryptocurrencyencyclopedia.common.Const
import xyz.teamgravity.cryptocurrencyencyclopedia.data.remote.CoinPaprikaApi
import xyz.teamgravity.cryptocurrencyencyclopedia.data.repository.CoinRepositoryImpl
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.repository.CoinRepository
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.use_case.get_coin.GetCoinUseCase
import xyz.teamgravity.cryptocurrencyencyclopedia.domain.use_case.get_coins.GetCoinsUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideCoinPaprikaApi(): CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(Const.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    @Provides
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository = CoinRepositoryImpl(api)

    @Provides
    fun provideGetCoinsUseCase(repository: CoinRepository) = GetCoinsUseCase(repository)

    @Provides
    fun provideGetCoinUseCase(repository: CoinRepository) = GetCoinUseCase(repository)
}