package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.BaseStatusModel
import com.example.pokedex.domain.model.BreedingsModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class BaseStatus(
    val hp: List<Int>,
    val attack: List<Int>,
    val defence: List<Int>,
    val specialAttack: List<Int>,
    val specialDefence: List<Int>,
    val speed: List<Int>
) : Parcelable

fun baseStatusToDomain(baseStatusModel: BaseStatusModel) : BaseStatus {
    return BaseStatus(
        hp = baseStatusModel.hp,
        attack = baseStatusModel.attack,
        defence = baseStatusModel.defence,
        specialAttack = baseStatusModel.specialAttack,
        specialDefence = baseStatusModel.specialDefence,
        speed = baseStatusModel.speed
    )
}



