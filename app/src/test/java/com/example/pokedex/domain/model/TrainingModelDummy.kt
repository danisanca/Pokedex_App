package com.example.pokedex.domain.model

import kotlin.random.Random

object TrainingModelDummy {

    fun getTrainingDummy()  = TrainingModel(
        evYield = "",
        catchRateModel = CatchRateModelDummy.getCatchRateDummy(),
        baseFriendshipModel = BaseFriendshipModelDummy.getBaseFriendshipModelDummy(),
        baseExp = Random.nextInt(),
        growthRate = ""
    )


}