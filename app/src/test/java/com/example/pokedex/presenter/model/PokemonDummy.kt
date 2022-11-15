package com.example.pokedex.presenter.model

import kotlin.random.Random

object PokemonDummy {

    fun getListPokemon() = listOf(getPokemonDummy())

    fun getPokemonDummy() = PokemonViewObject(
        id = Random.nextInt(),
        name = "",
        image = "",
        description = "",
        height = Random.nextFloat(),
        weight = Random.nextFloat(),
        species = "",
        types = listOf(),
        training = TrainingDummy.getTrainingDummy(),
        breeding = BreedingsDummy.getBreedingsDummy(),
        baseStatus = BaseStatusDummy.getBaseStatusDummy(),
        typeDefences = TypeDenfenceDummy.getTypeDenfenceDummy(),
        resourcesType = listOf(),
        mainType = PokemonResourcesDummy.getReouserce()
    )



}