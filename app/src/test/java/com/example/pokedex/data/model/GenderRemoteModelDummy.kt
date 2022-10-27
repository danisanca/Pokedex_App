package com.example.pokedex.data.model

import kotlin.random.Random

object GenderRemoteModelDummy {

    fun getGenderRemoteModelDummy() = GenderRemoteModel(
        male = Random.nextFloat(),
        female =  Random.nextFloat(),
    )
}