package com.example.pokedex.domain.model

import kotlin.random.Random

object PokemonModelDummy {

    fun getListPokemon() = listOf(getPokemonModelDummy())

    fun getPokemonModelDummy() = PokemonModel(
        id = Random.nextInt(),
        name = "",
        image = "",
        description = "",
        height = Random.nextFloat(),
        weight = Random.nextFloat(),
        species = "",
        types = listOf(),
        training = TrainingModelDummy.getTrainingDummy(),
        breeding = BreedingsModelDummy.getBreedingsModelDummy(),
        baseStatus = BaseStatusModelDummy.getBaseStatusModelDummy(),
        typeDefences = TypeDenfenceModelDummy.getTypeDenfenceModelDummy()
    )
}