package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

import kotlinx.serialization.Serializable

@Serializable
data class GenderRemoteModel(
    @SerializedName("male") val male:Float,
    @SerializedName("female") val female:Float
)



