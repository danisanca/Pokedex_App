package com.example.pokedex.service.constants

class PokedexConstants private constructor() {

    object MENUFILTER {
        const val GENERATION_OPTION = "generationOption"
        const val SORT_OPTION = "sortOption"
        const val FILTERS_OPTION = "filtersOption"
    }

    object GENERATION {
        const val GEN_1 = "gen1"
        const val GEN_2 = "gen2"
        const val GEN_3 = "gen3"
        const val GEN_4 = "gen4"
        const val GEN_5 = "gen5"
        const val GEN_6 = "gen6"
        const val GEN_7 = "gen7"
        const val GEN_8 = "gen8"
    }

    object SORT {
        const val SMALLEST = "smallest"
        const val HIGHEST = "highest"
        const val A_Z = "A_Z"
        const val Z_A = "Z_A"
    }

    object FILTERS {

        object TYPE {
            const val BUG = "bug"
            const val DARK = "dark"
            const val DRAGON = "dragon"
            const val ELECTRIC = "electric"
            const val FAIRY = "fairy"
            const val FIGHTING = "fighting"
            const val FIRE = "fire"
            const val FLYING = "flying"
            const val GHOST = "ghost"
            const val GRASS = "grass"
            const val GROUND = "ground"
            const val ICE = "ice"
            const val NORMAL = "normal"
            const val POISON = "poison"
            const val PSYCHIC = "psychic"
            const val ROCK = "rock"
            const val STEEL = "steel"
            const val WATER = "water"
        }

        object HEIGHTS {
            const val SHORT = "short"
            const val MEDIUM = "medium"
            const val TALL = "tall"
        }

        object WEIGHTS {
            const val LIGHT = "light"
            const val NORMAL = "normal"
            const val HEAVY = "heavy"
        }

    }


}