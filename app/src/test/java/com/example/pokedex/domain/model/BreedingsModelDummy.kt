package com.example.pokedex.domain.model

object BreedingsModelDummy {

    fun getBreedingsModelDummy() = BreedingsModel(
        eggGroups = listOf(),
        genderModel = GenderModelDummy.getGenderModelDummy(),
        eggCyclesModel = EggCycleModelDummy.getEggCycleModelDummy()
    )
}