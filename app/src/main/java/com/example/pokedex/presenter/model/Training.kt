package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.TrainingModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Training(

    var evYield: String,
    var catchRate: CatchRate,
    var baseFriendship: BaseFriendship,
    var baseExp: Int,
    var growthRate: String,
) : Parcelable

fun trainingToDomain(trainingModel: TrainingModel): Training {
    return Training(
        evYield = trainingModel.evYield,
        catchRate = catchRateToDomain(trainingModel.catchRateModel),
        baseFriendship = baseFriendshipToDomain(trainingModel.baseFriendshipModel),
        baseExp = trainingModel.baseExp,
        growthRate = trainingModel.growthRate
    )
}