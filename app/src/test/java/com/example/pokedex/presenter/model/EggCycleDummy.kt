package com.example.pokedex.presenter.model

import kotlin.random.Random

object EggCycleDummy {

    fun getEggCycleDummy() = EggCycle(
        value = Random.nextInt(),
        text = ""
    )

}