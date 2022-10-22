package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.EggCycleModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class EggCycle(
    val value: Int,
    val text: String,
) : Parcelable

fun eggCycleToDomain(eggCycleModel: EggCycleModel): EggCycle {
    return EggCycle(
        value = eggCycleModel.value,
        text = eggCycleModel.text
    )
}