package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class EggCycleRemoteModel(
    @SerializedName("value") val value:Int,
    @SerializedName("text") val text:String
)


