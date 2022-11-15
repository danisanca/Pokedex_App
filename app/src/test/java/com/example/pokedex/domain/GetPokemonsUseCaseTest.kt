package com.example.pokedex.domain

import com.example.pokedex.data.PokedexRepository
import com.example.pokedex.domain.model.PokemonModelDummy
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class GetPokemonsUseCaseTest {

    private lateinit var getPokemonsUseCase: GetPokemonsUseCase
    private val repository = mockk<PokedexRepository>()

    @Before
    fun setup() {
        getPokemonsUseCase = GetPokemonsUseCase(repository)
    }

    @Test
    fun `When getPokemons return sucess with a pokemon list`() = runBlocking {
        //GIVEN
        coEvery { repository.getPokemons() } returns PokemonModelDummy.getListPokemon()
        //WHEN
        val result = getPokemonsUseCase()
        //THEN
        Assert.assertTrue(result.isSuccess)

    }

    @Test
    fun `when getPokemons return any exception result `() = runBlocking {
        //GIVEN
        coEvery { repository.getPokemons() } throws Exception()
        //WHEN
        val result = getPokemonsUseCase()
        //THEN
        Assert.assertTrue(result.isFailure)
    }


}