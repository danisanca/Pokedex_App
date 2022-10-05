package com.example.pokedex.service.model

import kotlinx.serialization.Serializable

@Serializable
data class FilterModel (
    var height:String = "",
    var weight:String = "",
    var types:MutableList<String> = mutableListOf()

) {
    override fun toString(): String {
        return "FilterModel(height='$height', weight='$weight', types=$types)"
    }
}