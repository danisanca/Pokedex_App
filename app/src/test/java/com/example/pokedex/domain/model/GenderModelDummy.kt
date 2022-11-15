package com.example.pokedex.domain.model

import kotlin.random.Random

object GenderModelDummy {

    fun getGenderModelDummy() = GenderModel(
        male = Random.nextFloat(),
        female =  Random.nextFloat(),
    )
}