package com.example.pokedex.data.model

import com.example.pokedex.domain.model.CatchRateModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class CatchRateRemoteModel(
    @SerializedName("value") val value: Int,
    @SerializedName("text") val text: String,
)

fun CatchRateRemoteModel.toDomain(): CatchRateModel {
    return CatchRateModel(
        value = this.value,
        text = this.text
    )
}

