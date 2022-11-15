package com.example.pokedex.presenter.model

object BreedingsDummy {

    fun getBreedingsDummy() = Breedings(
        eggGroups = listOf(),
        genderModel = GenderDummy.getGenderDummy(),
        eggCyclesModel = EggCycleDummy.getEggCycleDummy()
    )
}