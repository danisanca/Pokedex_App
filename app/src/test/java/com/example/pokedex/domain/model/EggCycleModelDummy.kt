package com.example.pokedex.domain.model

import kotlin.random.Random

object EggCycleModelDummy {

    fun getEggCycleModelDummy() = EggCycleModel(
        value = Random.nextInt(),
        text = ""
    )

}