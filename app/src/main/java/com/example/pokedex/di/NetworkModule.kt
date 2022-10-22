package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.network.CheckNetworkConnection
import com.example.pokedex.network.PokedexInterceptor
import com.example.pokedex.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun providesCheckInternetConnection(
        @ApplicationContext applicationContext: Context,
    ) = CheckNetworkConnection(applicationContext)

    @Provides
    fun providespokedexInterceptor(checkNetworkConnection: CheckNetworkConnection) =
        PokedexInterceptor(checkNetworkConnection)

    @Provides
    fun providesServiceProvider(
        pokedexInterceptor: PokedexInterceptor,
    ) = ServiceProvider(pokedexInterceptor)

}