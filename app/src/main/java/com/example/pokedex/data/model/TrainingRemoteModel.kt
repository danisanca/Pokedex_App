package com.example.pokedex.data.model

import com.example.pokedex.domain.model.PokemonModel
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class TrainingRemoteModel(

    @SerializedName("evYield") val evYield: String,
    @SerializedName("catchRate") val catchRateModel: CatchRateRemoteModel,
    @SerializedName("baseFriendship") val baseFriendshipModel: BaseFriendshipRemoteModel,
    @SerializedName("baseExp") val baseExp: Int,
    @SerializedName("growthRate") val growthRate: String
)

