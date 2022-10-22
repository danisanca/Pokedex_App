package com.example.pokedex.domain

import com.example.pokedex.data.PokedexRepository
import com.example.pokedex.domain.model.PokemonModel
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokedexRepository,
) {
    suspend operator fun invoke(): Result<List<PokemonModel>> {
        return try {
            Result.success(repository.getPokemons())
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}