package com.example.pokedex.service.listener

import com.example.pokedex.presenter.model.PokemonViewObject

interface PokeListner {

    fun onListClick(objPoke: PokemonViewObject)

}