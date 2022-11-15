package com.example.pokedex.presenter.model

import kotlin.random.Random

object BaseFriendshipDummy {

    fun getBaseFriendshipDummy() = BaseFriendship(
        value = Random.nextFloat(),
        text = "this.text"
    )

}