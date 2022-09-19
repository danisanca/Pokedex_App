package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class Pokemon {

    @SerializedName("id")
    var id:Int = 0

    @SerializedName("name")
    var name:String = ""

    @SerializedName("image")
    var image:String = ""

    @SerializedName("description")
    var description:String = ""

    @SerializedName("height")
    var height:Int = 0

    @SerializedName("weight")
    var weight:Int = 0

    @SerializedName("species")
    var species:String = ""

    @SerializedName("types")
    var types:List<String> = mutableListOf()

    @SerializedName("training")
    var training:Training = Training()

    @SerializedName("breedings")
    var breeding:Breedings = Breedings()

    @SerializedName("baseStats")
    var baseStats:BaseStats = BaseStats()

    @SerializedName("typeDefences")
    var typeDefences:TypeDefence = TypeDefence()

}