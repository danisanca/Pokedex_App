package com.example.pokedex.data.model

import kotlin.random.Random

object TrainingRemoteDummy {

    fun getTrainingRemoteDummy()  = TrainingRemoteModel(
        evYield = "",
        catchRateModel = CatchRateRemoteModelDummy.getCatchRateDummy(),
        baseFriendshipModel = BaseFriendshipRemoteModelDummy.getBaseFriendshipModelDummy(),
        baseExp = Random.nextInt(),
        growthRate = ""
    )


}