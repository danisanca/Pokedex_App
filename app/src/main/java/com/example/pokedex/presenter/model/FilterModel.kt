package com.example.pokedex.presenter.model

import kotlinx.serialization.Serializable

@Serializable
data class FilterModel(
    var height: String = "",
    var weight: String = "",
    var types: MutableList<String> = mutableListOf(),
    var rangeMin: Float = 0f,
    var rangeMax: Float = 0f,

    ) {
    override fun toString(): String {
        return "FilterModel(height='$height', weight='$weight', types=$types, rangemin=$rangeMin, rangemax=$rangeMax)"
    }

}