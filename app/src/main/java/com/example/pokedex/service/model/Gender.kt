package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class Gender {

    @SerializedName("male")
    var value:Int = 0

    @SerializedName("female")
    var text:Int = 0
}