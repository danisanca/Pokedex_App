package com.example.pokedex.domain.model

data class TrainingModel(
    val evYield: String,
    val catchRateModel: CatchRateModel,
    val baseFriendshipModel: BaseFriendshipModel,
    val baseExp: Int,
    val growthRate: String
)



