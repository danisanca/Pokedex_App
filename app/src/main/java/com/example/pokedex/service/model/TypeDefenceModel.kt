package com.example.pokedex.service.model

import com.google.gson.annotations.SerializedName

class TypeDefenceModel {

    @SerializedName("normal")
    var normal:Float = 0f

    @SerializedName("fire")
    var fire:Float = 0f

    @SerializedName("water")
    var water:Float = 0f

    @SerializedName("electric")
    var electric:Float = 0f

    @SerializedName("grass")
    var grass:Float = 0f

    @SerializedName("ice")
    var ice:Float = 0f

    @SerializedName("fighting")
    var fighting:Float = 0f

    @SerializedName("poison")
    var poison:Float = 0f

    @SerializedName("ground")
    var ground:Float = 0f

    @SerializedName("flying")
    var flying:Float = 0f

    @SerializedName("psychic")
    var psychic:Float = 0f

    @SerializedName("bug")
    var bug:Float = 0f

    @SerializedName("rock")
    var rock:Float = 0f

    @SerializedName("ghost")
    var ghost:Float = 0f

    @SerializedName("dragon")
    var dragon:Float = 0f

    @SerializedName("darl")
    var dark:Float = 0f

    @SerializedName("steel")
    var steel:Float = 0f

    @SerializedName("fairy")
    var fairy:Float = 0f

    override fun toString(): String {
        return "TypeDefenceModel(normal=$normal, fire=$fire, water=$water, electric=$electric, grass=$grass, ice=$ice, fighting=$fighting, poison=$poison, ground=$ground, flying=$flying, psychic=$psychic, bug=$bug, rock=$rock, ghost=$ghost, dragon=$dragon, dark=$dark, steel=$steel, fairy=$fairy)"
    }


}