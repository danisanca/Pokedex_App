package com.example.pokedex.presenter.model

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pokedex.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class PokemonResources(

    val type: Int,
    @DrawableRes val icon: Int,
    @ColorRes val colorType: Int,
    @ColorRes val colorBackgroundType: Int,

    ) : Parcelable {

    BUG_RESOURCES(
        R.string.Bug_Name_Resources,
        R.drawable.ic_bug,
        R.color.typeBug,
        R.color.bkgTypeBug
    ),
    DARK_RESOURCES(
        R.string.Dark_Name_Resources,
        R.drawable.ic_dark,
        R.color.typeDark,
        R.color.bkgTypeDark
    ),
    DRAGON_RESOURCES(
        R.string.Dragon_Name_Resources,
        R.drawable.ic_dragon,
        R.color.typeDragon,
        R.color.bkgTypeDragon
    ),
    ELECTRIC_RESOURCES(
        R.string.Electric_Name_Resources,
        R.drawable.ic_electric,
        R.color.typeElectric,
        R.color.bkgTypeElectric
    ),
    FAIRY_RESOURCES(
        R.string.Fairy_Name_Resources,
        R.drawable.ic_fairy,
        R.color.typeFairy,
        R.color.bkgTypeFairy
    ),
    FIGHTING_RESOURCES(
        R.string.Fighting_Name_Resources,
        R.drawable.ic_fighting,
        R.color.typeFighting,
        R.color.bkgTypeFighting
    ),
    FIRE_RESOURCES(
        R.string.Fire_Name_Resources,
        R.drawable.ic_fire,
        R.color.typeFire,
        R.color.bkgTypeFire
    ),
    FLYING_RESOURCES(
        R.string.Flying_Name_Resources,
        R.drawable.ic_flying,
        R.color.typeFlying,
        R.color.bkgTypeFlying
    ),
    GHOST_RESOURCES(
        R.string.Ghost_Name_Resources,
        R.drawable.ic_ghost,
        R.color.typeGhost,
        R.color.bkgTypeGhost
    ),
    GRASS_RESOURCES(
        R.string.Grass_Name_Resources,
        R.drawable.ic_grass,
        R.color.typeGrass,
        R.color.bkgTypeGrass
    ),
    GROUND_RESOURCES(
        R.string.Ground_Name_Resources,
        R.drawable.ic_ground,
        R.color.typeGround,
        R.color.bkgTypeGround
    ),
    ICE_RESOURCES(
        R.string.Ice_Name_Resources,
        R.drawable.ic_ice,
        R.color.typeIce,
        R.color.bkgTypeIce
    ),
    NORMAL_RESOURCES(
        R.string.Normal_Name_Resources,
        R.drawable.ic_normal,
        R.color.typeNormal,
        R.color.bkgTypeNormal
    ),
    POISON_RESOURCES(
        R.string.Poison_Name_Resources,
        R.drawable.ic_poison,
        R.color.typePoison,
        R.color.bkgTypePoison
    ),
    PSYCHIC_RESOURCES(
        R.string.Psychic_Name_Resources,
        R.drawable.ic_psychic,
        R.color.typePsychic,
        R.color.bkgTypePsychic
    ),
    ROCK_RESOURCES(
        R.string.Rock_Name_Resources,
        R.drawable.ic_rock,
        R.color.typeRock,
        R.color.bkgTypeRock
    ),
    STEEL_RESOURCES(
        R.string.Steel_Name_Resources,
        R.drawable.ic_steel,
        R.color.typeSteel,
        R.color.bkgTypeSteel
    ),
    WATER_RESOURCES(
        R.string.Water_Name_Resources,
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