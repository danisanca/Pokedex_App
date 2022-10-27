package com.example.pokedex.data.model

import kotlin.random.Random

object PokemonRemoteDummy {

    fun getListPokemonRemote() = listOf(getPokemonRemoteDummy())

    fun getPokemonRemoteDummy() = PokemonRemoteModel(
        id = Random.nextInt(),
        name = "",
        image = "",
        description = "",
        height = Random.nextFloat(),
        weight = Random.nextFloat(),
        species = "",
        types = listOf(),
        training = TrainingRemoteDummy.getTrainingRemoteDummy(),
        breeding = BreedingsRemoteModelDummy.getBreedingsRemoteModelDummy(),
        baseStatus = BaseStatusRemoteModelDummy.getBaseStatusRemoteModelDummy(),
        typeDefences = TypeDenfenceRemoteModelDummy.getTypeDenfenceRemoteModelDummy()
    )
}