package com.example.pokedex.data.model

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
    @SerializedName("fairy") val fairy: Float
)



