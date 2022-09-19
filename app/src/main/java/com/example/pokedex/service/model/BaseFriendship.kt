package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class BaseFriendship {

    @SerializedName("value")
    var value:Int = 0

    @SerializedName("text")
    var text:String = ""

}