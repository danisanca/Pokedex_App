package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class Breedings {

    @SerializedName("eggGroups")
    var eggGroups:List<String> = mutableListOf()

    @SerializedName("gender")
    var gender:Gender = Gender()

    @SerializedName("eggCycles")
    var eggCycles:EggCycle = EggCycle()

}