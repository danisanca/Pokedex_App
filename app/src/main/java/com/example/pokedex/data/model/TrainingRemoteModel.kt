package com.example.pokedex.data.model

import com.example.pokedex.domain.model.PokemonModel
import com.example.pokedex.domain.model.TrainingModel
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

fun TrainingRemoteModel.toDomain():TrainingModel{
    return TrainingModel(
        evYield = this.evYield,
        catchRateModel = this.catchRateModel.toDomain(),
        baseFriendshipModel = this.baseFriendshipModel.toDomain(),
        baseExp = this.baseExp,
        growthRate = this.growthRate

    )
}

