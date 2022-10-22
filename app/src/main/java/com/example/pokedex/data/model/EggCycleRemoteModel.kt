package com.example.pokedex.data.model

import com.example.pokedex.domain.model.EggCycleModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class EggCycleRemoteModel(
    @SerializedName("value") val value: Int,
    @SerializedName("text") val text: String,
)

fun EggCycleRemoteModel.toDomain(): EggCycleModel {
    return EggCycleModel(
        value = this.value,
        text = this.text
    )
}

