package com.example.pokedex.data.model

import kotlin.random.Random

object CatchRateRemoteModelDummy {

    fun getCatchRateDummy() = CatchRateRemoteModel(
        value = Random.nextInt(),
        text = "this.text"
    )


}