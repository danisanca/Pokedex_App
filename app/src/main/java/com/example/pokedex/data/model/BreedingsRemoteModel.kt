package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class BreedingsRemoteModel(
    @SerializedName("eggGroups") val eggGroups: List<String>,
    @SerializedName("gender") val genderModel: GenderRemoteModel,
    @SerializedName("eggCycles") val eggCyclesModel: EggCycleRemoteModel
)



