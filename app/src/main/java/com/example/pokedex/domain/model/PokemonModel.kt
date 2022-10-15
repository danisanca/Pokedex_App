package com.example.pokedex.domain.model

import com.example.pokedex.data.model.BaseStatusRemoteModel
import com.example.pokedex.data.model.BreedingsRemoteModel
import com.example.pokedex.data.model.TrainingRemoteModel
import com.example.pokedex.data.model.TypeDefenceRemoteModel

data class PokemonModel(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val species: String,
    val types: List<String>,
    val training: TrainingRemoteModel,
    val breeding: BreedingsRemoteModel,
    val baseStatus: BaseStatusRemoteModel,
    val typeDefences: TypeDefenceRemoteModel,
)




