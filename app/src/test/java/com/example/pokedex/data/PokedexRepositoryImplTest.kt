package com.example.pokedex.data

import com.example.pokedex.data.api.PokedexAPI
import com.example.pokedex.data.exception.PokedexRepositoryException
import com.example.pokedex.data.model.PokemonRemoteDummy
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.HttpException

class PokedexRepositoryImplTest {

    private lateinit var pokedexRepositoryImpl: PokedexRepositoryImpl

    @MockK
    lateinit var pokedexService: PokedexAPI

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        pokedexRepositoryImpl = PokedexRepositoryImpl(pokedexService)
    }

    @Test
    fun `getPokemons return success with a list of pokemons`() = runBlocking {
        //GIVEN
        coEvery { pokedexService.getPokemons() } returns
                PokemonRemoteDummy.getListPokemonRemote()
        //WHEN
        val result = pokedexRepositoryImpl.getPokemons()
        //THEN
        Assert.assertFalse(result.isEmpty())
    }

    @Test(expected = PokedexRepositoryException::class)
    fun `getMovies throws generic exception`() = runBlocking {
        //GIVEN
        coEvery { pokedexService.getPokemons() } throws Exception()
        //WHEN
        val result = pokedexRepositoryImpl.getPokemons()
    }

}