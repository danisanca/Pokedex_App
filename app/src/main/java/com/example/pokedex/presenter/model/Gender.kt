package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.BaseFriendshipModel
import com.example.pokedex.domain.model.GenderModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Gender(
    val male: Float,
    val female: Float
) : Parcelable

fun genderToDomain(genderModel: GenderModel) : Gender {
    return Gender(
        male = genderModel.male,
        female = genderModel.female
    )
}


