package com.example.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.service.listener.APIListener
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.service.repository.PokemonRepository

class ListPokeViewModel:ViewModel() {

    private val pokemonRepository = PokemonRepository()

    private val _pokemonModel = MutableLiveData<List<PokemonModel>>()
    val pokemonModel:LiveData<List<PokemonModel>> = _pokemonModel

    private val _statusMsg = MutableLiveData<String>()
    val statusMsg:LiveData<String> = _statusMsg

    fun listPokes(){
       pokemonRepository.list(object : APIListener<List<PokemonModel>>{
           override fun onSuccess(result: List<PokemonModel>) {
               _pokemonModel.value = result
           }

           override fun onFailure(message: String) {
               _statusMsg.value = message
           }

       })

    }

}