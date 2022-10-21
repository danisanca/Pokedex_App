package com.example.pokedex.data.model

import com.example.pokedex.domain.model.GenderModel
import com.example.pokedex.domain.model.PokemonModel
import com.google.gson.annotations.SerializedName

import kotlinx.serialization.Serializable

@Serializable
data class GenderRemoteModel(
    @SerializedName("male") val male:Float,
    @SerializedName("female") val female:Float
)
fun GenderRemoteModel.toDomain() : GenderModel {
    return GenderModel(
        male = this.male,
        female = this.female
    )
}


