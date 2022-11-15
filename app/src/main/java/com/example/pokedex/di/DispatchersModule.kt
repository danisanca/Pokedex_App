package com.example.pokedex.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier

@Module
@InstallIn(ViewModelComponent::class)
object DispatchersModule {

    @Provides
    @DispatcherIo
    fun providesDispatcherIo(): CoroutineDispatcher = Dispatchers.IO

}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class DispatcherIo