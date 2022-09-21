package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class BreedingsModel {

    @SerializedName("eggGroups")
    var eggGroups:List<String> = mutableListOf()

    @SerializedName("gender")
    var genderModel:GenderModel = GenderModel()

    @SerializedName("eggCycles")
    var eggCyclesModel:EggCycleModel = EggCycleModel()

}