package com.example.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pokedex.service.model.Pokemon

class ListPokeViewModel:ViewModel() {

    private val _pokemon = MutableLiveData<List<Pokemon>>()
    val pokemon:LiveData<List<Pokemon>> = _pokemon

    fun getListPokes(){
        var pokeList:MutableList<Pokemon> = mutableListOf()
        val poke:Pokemon = Pokemon().apply {
            this.id = 11
            this.name = "Grass"
            this.types = mutableListOf("Grass","Poison")
        }
        pokeList.add(poke)
        _pokemon.value =pokeList
    }

}