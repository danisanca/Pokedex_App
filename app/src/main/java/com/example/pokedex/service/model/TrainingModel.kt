package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class TrainingModel {

    @SerializedName("evYield")
    var evYield:String =""

    @SerializedName("catchRate")
    var catchRateModel:CatchRateModel = CatchRateModel()

    @SerializedName("baseFriendship")
    var baseFriendshipModel:BaseFriendshipModel = BaseFriendshipModel()

    @SerializedName("baseExp")
    var baseExp:Int = 0

    @SerializedName("growthRate")
    var growthRate:String = ""


}