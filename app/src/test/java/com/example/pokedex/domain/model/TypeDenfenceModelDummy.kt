package com.example.pokedex.domain.model

import kotlin.random.Random

object TypeDenfenceModelDummy {

    fun getTypeDenfenceModelDummy() = TypeDefenceModel(
        normal = Random.nextFloat(),
        fire =  Random.nextFloat(),
        water =  Random.nextFloat(),
        electric =  Random.nextFloat(),
        grass =  Random.nextFloat(),
        ice =  Random.nextFloat(),
        fighting =  Random.nextFloat(),
        poison =  Random.nextFloat(),
        ground =  Random.nextFloat(),
        flying = Random.nextFloat(),
        psychic =  Random.nextFloat(),
        bug =  Random.nextFloat(),
        rock =  Random.nextFloat(),
        ghost =  Random.nextFloat(),
        dragon = Random.nextFloat(),
        dark =  Random.nextFloat(),
        steel =  Random.nextFloat(),
        fairy =  Random.nextFloat(),
    )

}