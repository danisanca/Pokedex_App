package com.example.pokedex.di

import android.content.Context
import com.example.pokedex.presenter.model.SecurityPreferences
import com.example.pokedex.presenter.viewmodel.ListPokeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PresenterModule {

    @Provides
    fun providesSecurityPreferences(
        @ApplicationContext applicationContext: Context,
    ) = SecurityPreferences(applicationContext)

}
