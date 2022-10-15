package com.example.pokedex.di

import com.example.pokedex.data.PokedexRepository
import com.example.pokedex.data.PokedexRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsPokedexRepository(
       pokedexRepositoryImpl: PokedexRepositoryImpl
    ): PokedexRepository
}