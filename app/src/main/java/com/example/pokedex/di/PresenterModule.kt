package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.network.CheckNetworkConnection
import com.example.pokedex.network.PokedexInterceptor
import com.example.pokedex.network.ServiceProvider
import com.example.pokedex.presenter.model.SecurityPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresenterModule {

    @Provides
    fun providesSecurityPreferences(
        @ApplicationContext applicationContext: Context
    ) = SecurityPreferences(applicationContext)


}