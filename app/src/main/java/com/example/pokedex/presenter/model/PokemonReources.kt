package com.example.pokedex.presenter.model

import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import com.example.pokedex.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class PokemonReources(
    val type: String,
    @DrawableRes val icon: Int,
    @ColorRes val colorType: Int,
    @ColorRes val colorBackgroundType: Int,

    ) : Parcelable {
    BUG_RESOURCES(
        "bug",
        R.drawable.ic_bug,
        R.color.typeBug,
        R.color.bkgTypeBug
    ),
    DARK_RESOURCES(
        "dark",
        R.drawable.ic_dark,
        R.color.typeDark,
        R.color.bkgTypeDark
    ),
    DRAGON_RESOURCES(
        "dragon",
        R.drawable.ic_dragon,
        R.color.typeDragon,
        R.color.bkgTypeDragon
    ),
    ELECTRIC_RESOURCES(
        "electric",
        R.drawable.ic_electric,
        R.color.typeElectric,
        R.color.bkgTypeElectric
    ),
    FAIRY_RESOURCES(
        "fairy",
        R.drawable.ic_fairy,
        R.color.typeFairy,
        R.color.bkgTypeFairy
    ),
    FIGHTING_RESOURCES(
        "fighting",
        R.drawable.ic_fighting,
        R.color.typeFighting,
        R.color.bkgTypeFighting
    ),
    FIRE_RESOURCES(
        "fire",
        R.drawable.ic_fire,
        R.color.typeFire,
        R.color.bkgTypeFire
    ),
    FLYING_RESOURCES(
        "flying",
        R.drawable.ic_flying,
        R.color.typeFlying,
        R.color.bkgTypeFlying
    ),
    GHOST_RESOURCES(
        "ghost",
        R.drawable.ic_ghost,
        R.color.typeGhost,
        R.color.bkgTypeGhost
    ),
    GRASS_RESOURCES(
        "grass",
        R.drawable.ic_grass,
        R.color.typeGrass,
        R.color.bkgTypeGrass
    ),
    GROUND_RESOURCES(
        "ground",
        R.drawable.ic_ground,
        R.color.typeGround,
        R.color.bkgTypeGround
    ),
    ICE_RESOURCES(
        "ice",
        R.drawable.ic_ice,
        R.color.typeIce,
        R.color.bkgTypeIce
    ),
    NORMAL_RESOURCES(
        "normal",
        R.drawable.ic_normal,
        R.color.typeNormal,
        R.color.bkgTypeNormal
    ),
    POISON_RESOURCES(
        "poison",
        R.drawable.ic_poison,
        R.color.typePoison,
        R.color.bkgTypePoison
    ),
    PSYCHIC_RESOURCES(
        "psychic",
        R.drawable.ic_psychic,
        R.color.typePsychic,
        R.color.bkgTypePsychic
    ),
    ROCK_RESOURCES(
        "rock",
        R.drawable.ic_rock,
        R.color.typeRock,
        R.color.bkgTypeRock
    ),
    STEEL_RESOURCES(
        "steel",
        R.drawable.ic_steel,
        R.color.typeSteel,
        R.color.bkgTypeSteel
    ),
    WATER_RESOURCES(
        "water",
        R.drawable.ic_water,
        R.color.typeWater,
        R.color.bkgTypeWater
    );

    companion object {
        fun getPokemonType(type: String) = when (type) {
            "bug" -> BUG_RESOURCES
            "dark" -> DARK_RESOURCES
            "dragon" -> DRAGON_RESOURCES
            "fairy" -> FAIRY_RESOURCES
            "fighting" -> FIGHTING_RESOURCES
            "fire" -> FIRE_RESOURCES
            "flying" -> FLYING_RESOURCES
            "ghost" -> GHOST_RESOURCES
            "grass" -> GRASS_RESOURCES
            "ground" -> GROUND_RESOURCES
            "ice" -> ICE_RESOURCES
            "normal" -> NORMAL_RESOURCES
            "poison" -> POISON_RESOURCES
            "psychic" -> PSYCHIC_RESOURCES
            "rock" -> ROCK_RESOURCES
            "steel" -> STEEL_RESOURCES
            "water" -> WATER_RESOURCES
            "electric" -> ELECTRIC_RESOURCES
            else -> throw Exception()
        }
    }
}