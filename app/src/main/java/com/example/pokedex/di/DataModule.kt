package com.example.pokedex.di

import com.example.pokedex.data.api.PokedexAPI
import com.example.pokedex.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DataModule {
    @Provides
    fun providesDiscoverApi(serviceProvider: ServiceProvider): PokedexAPI {
        return serviceProvider.createService(PokedexAPI::class.java)
    }
}