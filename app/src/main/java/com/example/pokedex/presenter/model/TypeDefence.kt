package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.TypeDefenceModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class TypeDefence(
    var normal: Float,
    var fire: Float,
    var water: Float,
    var electric: Float,
    var grass: Float,
    var ice: Float,
    var fighting: Float,
    var poison: Float,
    var ground: Float,
    var flying: Float,
    var psychic: Float,
    var bug: Float,
    var rock: Float,
    var ghost: Float,
    var dragon: Float,
    var dark: Float,
    var steel: Float,
    var fairy: Float,
) : Parcelable

fun typeDefenceToDomain(typeDefence: TypeDefenceModel): TypeDefence {
    return TypeDefence(
        normal = typeDefence.normal,
        fire = typeDefence.fire,
        water = typeDefence.water,
        electric = typeDefence.electric,
        grass = typeDefence.grass,
        ice = typeDefence.ice,
        fighting = typeDefence.fighting,
        poison = typeDefence.poison,
        ground = typeDefence.ground,
        flying = typeDefence.flying,
        psychic = typeDefence.psychic,
        bug = typeDefence.bug,
        rock = typeDefence.rock,
        ghost = typeDefence.ghost,
        dragon = typeDefence.dragon,
        dark = typeDefence.dark,
        steel = typeDefence.steel,
        fairy = typeDefence.fairy
    )
}