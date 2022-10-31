package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.BaseFriendshipModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseFriendship(
    val value: Float,
    val text: String,
) : Parcelable

fun baseFriendshipToDomain(baseFriendship: BaseFriendshipModel): BaseFriendship {
    return BaseFriendship(
        value = baseFriendship.value,
        text = baseFriendship.text
    )
}