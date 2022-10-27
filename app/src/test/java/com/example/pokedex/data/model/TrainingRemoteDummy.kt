package com.example.pokedex.data.model

import kotlin.random.Random

object TrainingRemoteDummy {

    fun getTrainingRemoteDummy()  = TrainingRemoteModel(
        evYield = "",
        catchRateModel = CatchRateModelDummy.getCatchRateDummy(),
        baseFriendshipModel = BaseFriendshipModelDummy.getBaseFriendshipModelDummy(),
        baseExp = Random.nextInt(),
        growthRate = ""
    )


}