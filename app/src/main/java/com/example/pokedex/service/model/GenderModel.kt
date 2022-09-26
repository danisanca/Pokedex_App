package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class GenderModel {

    @SerializedName("male")
    var male:Float = 0f

    @SerializedName("female")
    var female:Float = 0f
}