package com.example.pokedex.domain.model

object BaseStatusModelDummy {

    fun getBaseStatusModelDummy() = BaseStatusModel(
        hp = listOf(),
        attack = listOf(),
        defence = listOf(),
        specialAttack = listOf(),
        specialDefence = listOf(),
        speed = listOf()
    )

}