package com.example.pokedex.data.model

import com.example.pokedex.domain.model.BreedingsModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class BreedingsRemoteModel(
    @SerializedName("eggGroups") val eggGroups: List<String>,
    @SerializedName("gender") val genderModel: GenderRemoteModel,
    @SerializedName("eggCycles") val eggCyclesModel: EggCycleRemoteModel,
)

fun BreedingsRemoteModel.toDomain(): BreedingsModel {
    return BreedingsModel(
        eggGroups = this.eggGroups,
        genderModel = this.genderModel.toDomain(),
        eggCyclesModel = this.eggCyclesModel.toDomain()
    )
}