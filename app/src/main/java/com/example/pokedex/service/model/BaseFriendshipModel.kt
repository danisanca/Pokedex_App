package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class BaseFriendshipModel {

    @SerializedName("value")
    var value:Float = 0f

    @SerializedName("text")
    var text:String = ""

}