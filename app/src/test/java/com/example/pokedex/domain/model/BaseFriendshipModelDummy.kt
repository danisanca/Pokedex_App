package com.example.pokedex.domain.model

import kotlin.random.Random

object BaseFriendshipModelDummy {

    fun getBaseFriendshipModelDummy() = BaseFriendshipModel(
        value = Random.nextFloat(),
        text = "this.text"
    )

}