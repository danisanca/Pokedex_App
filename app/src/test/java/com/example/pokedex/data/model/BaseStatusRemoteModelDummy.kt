package com.example.pokedex.data.model

import kotlin.random.Random

object BaseStatusRemoteModelDummy {

    fun getBaseStatusRemoteModelDummy() = BaseStatusRemoteModel(
        hp = listOf(),
        attack = listOf(),
        defence = listOf(),
        specialAttack = listOf(),
        specialDefence = listOf(),
        speed = listOf()
    )

}