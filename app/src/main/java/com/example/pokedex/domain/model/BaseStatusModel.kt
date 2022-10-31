package com.example.pokedex.domain.model

data class BaseStatusModel(
    val hp: List<Int>,
    val attack: List<Int>,
    val defence: List<Int>,
    val specialAttack: List<Int>,
    val specialDefence: List<Int>,
    val speed: List<Int>,
)