package com.example.pokedex.presenter.model

import kotlin.random.Random

object CatchRateDummy {

    fun getCatchRateDummy() = CatchRate(
        value = Random.nextInt(),
        text = "this.text"
    )


}