package com.example.pokedex.domain.model

data class TrainingModel(

    var evYield: String,
    var catchRateModel: CatchRateModel,
    var baseFriendshipModel: BaseFriendshipModel,
    var baseExp: Int,
    var growthRate: String
)