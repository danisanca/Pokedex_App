package com.example.pokedex.presenter.model

import kotlin.random.Random

object GenderDummy {

    fun getGenderDummy() = Gender(
        male = Random.nextFloat(),
        female =  Random.nextFloat(),
    )
}