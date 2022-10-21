package com.example.pokedex.data.model

import com.example.pokedex.domain.model.BaseStatusModel
import com.example.pokedex.domain.model.PokemonModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class BaseStatusRemoteModel(
    @SerializedName("hp") val hp: List<Int>,
    @SerializedName("attack") val attack: List<Int>,
    @SerializedName("defence") val defence: List<Int>,
    @SerializedName("specialAttack") val specialAttack: List<Int>,
    @SerializedName("specialDefence") val specialDefence: List<Int>,
    @SerializedName("speed") val speed: List<Int>,
)

fun BaseStatusRemoteModel.toDomain() : BaseStatusModel {
    return BaseStatusModel(
        hp = this.hp,
        attack = this.attack,
        defence = this.defence,
        specialAttack = this.specialAttack,
        specialDefence = this.specialDefence,
        speed = this.speed
    )
}


