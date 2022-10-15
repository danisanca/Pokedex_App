package com.example.pokedex.data.model

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




