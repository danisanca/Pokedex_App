package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class BaseStats {

    @SerializedName("hp")
    var hp:List<Int> = mutableListOf()

    @SerializedName("attack")
    var attack:List<Int> = mutableListOf()

    @SerializedName("defence")
    var defence:List<Int> = mutableListOf()

    @SerializedName("specialAttack")
    var specialAttack:List<Int> = mutableListOf()

    @SerializedName("specialDefence")
    var specialDefence:List<Int> = mutableListOf()

    @SerializedName("speed")
    var speed:List<Int> = mutableListOf()
}