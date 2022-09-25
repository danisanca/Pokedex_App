package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable


class PokemonModel  {

    @SerializedName("id")
    var id:Int = 0

    @SerializedName("name")
    var name:String = ""

    @SerializedName("image")
    var image:String = ""

    @SerializedName("description")
    var description:String = ""

    @SerializedName("height")
    var height:Float = 0f

    @SerializedName("weight")
    var weight:Float = 0f

    @SerializedName("species")
    var species:String = ""

    @SerializedName("types")
    var types:List<String> = mutableListOf()

    @SerializedName("training")
    var trainingModel:TrainingModel = TrainingModel()

    @SerializedName("breedings")
    var breeding:BreedingsModel = BreedingsModel()

    @SerializedName("baseStats")
    var baseStatusModel:BaseStatusModel = BaseStatusModel()

    @SerializedName("typeDefences")
    var typeDefencesModel:TypeDefenceModel = TypeDefenceModel()

    override fun toString(): String {
        return "PokemonModel:\n id=$id, \n name='$name', \n image='$image', \n description='$description', \n height=$height, \nweight=$weight, \n species='$species', \n types=$types, \n training=$trainingModel, \n breeding=$breeding, \n baseStats=$baseStatusModel, \n typeDefences=$typeDefencesModel"
    }

}