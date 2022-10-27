package com.example.pokedex.data.model

object BreedingsRemoteModelDummy {

    fun getBreedingsRemoteModelDummy() = BreedingsRemoteModel(
        eggGroups = listOf(),
        genderModel = GenderRemoteModelDummy.getGenderRemoteModelDummy(),
        eggCyclesModel = EggCycleRemoteModelDummy.getEggCycleRemoteModelDummy()
    )
}