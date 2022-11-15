package com.example.pokedex.presenter.model

import kotlin.random.Random

object TrainingDummy {

    fun getTrainingDummy()  = Training(
        evYield = "",
        catchRate = CatchRateDummy.getCatchRateDummy(),
        baseFriendship = BaseFriendshipDummy.getBaseFriendshipDummy(),
        baseExp = Random.nextInt(),
        growthRate = ""
    )


}