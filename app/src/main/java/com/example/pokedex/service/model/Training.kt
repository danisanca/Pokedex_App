package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class Training {

    @SerializedName("evYield")
    var evYield:String =""

    @SerializedName("catchRate")
    var catchRate:CatchRate = CatchRate()

    @SerializedName("baseFriendship")
    var baseFriendship:BaseFriendship = BaseFriendship()

    @SerializedName("baseExp")
    var baseExp:Int = 0

    @SerializedName("growthRate")
    var growthRate:String = ""


}