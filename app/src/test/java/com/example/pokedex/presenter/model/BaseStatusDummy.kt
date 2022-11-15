package com.example.pokedex.presenter.model

object BaseStatusDummy {

    fun getBaseStatusDummy() = BaseStatus(
        hp = listOf(),
        attack = listOf(),
        defence = listOf(),
        specialAttack = listOf(),
        specialDefence = listOf(),
        speed = listOf()
    )

}