package com.example.pokedex.data.model

import kotlin.random.Random

object EggCycleRemoteModelDummy {

    fun getEggCycleRemoteModelDummy() = EggCycleRemoteModel(
        value = Random.nextInt(),
        text = ""
    )

}