package com.example.pokedex.data

import com.example.pokedex.domain.model.PokemonModel

interface PokedexRepository {
    suspend fun getPokemons():List<PokemonModel>
}