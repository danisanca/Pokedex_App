package com.example.pokedex.service.repository.remote

import com.example.pokedex.service.model.PokemonModel
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    @GET(".")
    fun list(): Call<List<PokemonModel>>

}