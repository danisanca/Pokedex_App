package com.example.pokedex.data


import com.example.pokedex.data.api.PokedexAPI
import com.example.pokedex.data.exception.PokedexRepositoryException
import com.example.pokedex.data.model.toDomain
import com.example.pokedex.domain.model.PokemonModel
import retrofit2.HttpException
import javax.inject.Inject

class PokedexRepositoryImpl @Inject constructor(
    private val pokedexService: PokedexAPI,
) : PokedexRepository {

    override suspend fun getPokemons(): List<PokemonModel> {
        return try {
            pokedexService.getPokemons().map {
                it.toDomain()
            }
        } catch (ex: Exception) {
            throw PokedexRepositoryException()
        }
    }
}