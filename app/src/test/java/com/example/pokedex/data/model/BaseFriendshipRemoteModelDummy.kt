package com.example.pokedex.data.model

import kotlin.random.Random

object BaseFriendshipRemoteModelDummy {

    fun getBaseFriendshipModelDummy() = BaseFriendshipRemoteModel(
        value = Random.nextFloat(),
        text = "this.text"
    )

}