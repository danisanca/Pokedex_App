package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.CatchRateModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class CatchRate(
    val value: Int,
    val text: String,
) : Parcelable

fun catchRateToDomain(catchRateModel: CatchRateModel): CatchRate {
    return CatchRate(
        value = catchRateModel.value,
        text = catchRateModel.text
    )
}