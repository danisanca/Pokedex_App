package com.example.pokedex.data.model

import com.example.pokedex.domain.model.BaseFriendshipModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class BaseFriendshipRemoteModel(
    @SerializedName("value") val value: Float,
    @SerializedName("text") val text: String,
)

fun BaseFriendshipRemoteModel.toDomain(): BaseFriendshipModel {
    return BaseFriendshipModel(
        value = this.value,
        text = this.text
    )
}