package com.example.pokedex.data.model

import com.example.pokedex.domain.model.TypeDefenceModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TypeDefenceRemoteModel(
    @SerializedName("normal") val normal: Float,
    @SerializedName("fire") val fire: Float,
    @SerializedName("water") val water: Float,
    @SerializedName("electric") val electric: Float,
    @SerializedName("grass") val grass: Float,
    @SerializedName("ice") val ice: Float,
    @SerializedName("fighting") val fighting: Float,
    @SerializedName("poison") val poison: Float,
    @SerializedName("ground") val ground: Float,
    @SerializedName("flying") val flying: Float,
    @SerializedName("psychic") val psychic: Float,
    @SerializedName("bug") val bug: Float,
    @SerializedName("rock") val rock: Float,
    @SerializedName("ghost") val ghost: Float,
    @SerializedName("dragon") val dragon: Float,
    @SerializedName("darl") val dark: Float,
    @SerializedName("steel") val steel: Float,
    @SerializedName("fairy") val fairy: Float,
)

fun TypeDefenceRemoteModel.toDomain(): TypeDefenceModel {
    return TypeDefenceModel(
        normal = this.normal,
        fire = this.fire,
        water = this.water,
        electric = this.electric,
        grass = this.grass,
        ice = this.ice,
        fighting = this.fighting,
        poison = this.poison,
        ground = this.ground,
        flying = this.flying,
        psychic = this.psychic,
        bug = this.bug,
        rock = this.rock,
        ghost = this.ghost,
        dragon = this.dragon,
        dark = this.dark,
        steel = this.steel,
        fairy = this.fairy
    )
}


