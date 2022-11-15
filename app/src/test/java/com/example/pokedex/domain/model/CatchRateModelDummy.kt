package com.example.pokedex.domain.model

import kotlin.random.Random

object CatchRateModelDummy {

    fun getCatchRateDummy() = CatchRateModel(
        value = Random.nextInt(),
        text = "this.text"
    )


}