package com.example.pokedex.presenter

import android.app.Application
import android.drm.DrmStore.DrmObjectType.CONTENT
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokedex.domain.GetPokemonsUseCase
import com.example.pokedex.domain.model.PokemonModelDummy
import com.example.pokedex.presenter.model.PokemonDummy
import com.example.pokedex.presenter.model.SecurityPreferences
import com.example.pokedex.presenter.model.ViewState
import com.example.pokedex.presenter.viewmodel.ListPokeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.*

@ExperimentalCoroutinesApi
class ListPokeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var listPokeViewModel: ListPokeViewModel

    private val getPokemonsUseCase = mockk<GetPokemonsUseCase>()
    private val securityPreferences = mockk<SecurityPreferences>()
    private val application = mockk<Application>()

    @Before
    fun setup() {
        val dispatcherTest = StandardTestDispatcher()
        Dispatchers.setMain(dispatcherTest)
        listPokeViewModel =
            ListPokeViewModel(dispatcherTest, getPokemonsUseCase, securityPreferences, application)
    }

    @Test
    fun `when getPokemonsUserCase retuns sucess ViewState will be set as CONTENT`() = runTest {

        //GIVEN
        coEvery { getPokemonsUseCase() } returns Result.success(PokemonModelDummy.getListPokemon())

        //WHEN
        listPokeViewModel.getPokemons()

        //THEN
        advanceUntilIdle()
        Assert.assertNotNull(listPokeViewModel.pokemonList.value)
        Assert.assertEquals(ViewState.OK, listPokeViewModel.viewState.value)

    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}