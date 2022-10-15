package com.example.pokedex.data.api

import com.example.pokedex.data.model.PokemonRemoteModel
import retrofit2.http.GET

interface PokedexAPI {

    @GET(".")
    suspend fun getPokemons(): List<PokemonRemoteModel>

}