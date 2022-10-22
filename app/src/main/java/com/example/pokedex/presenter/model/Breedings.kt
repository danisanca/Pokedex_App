package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.BreedingsModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Breedings(
    val eggGroups: List<String>,
    val genderModel: Gender,
    val eggCyclesModel: EggCycle,
) : Parcelable

fun breedingsToDomain(breedingsModel: BreedingsModel): Breedings {
    return Breedings(
        eggGroups = breedingsModel.eggGroups,
        genderModel = genderToDomain(breedingsModel.genderModel),
        eggCyclesModel = eggCycleToDomain(breedingsModel.eggCyclesModel)
    )
}

