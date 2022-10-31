package com.example.pokedex.domain.model

data class  PokemonModel(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val species: String,
    val types: List<String>,
    val training: TrainingModel,
    val breeding: BreedingsModel,
    val baseStatus: BaseStatusModel,
    val typeDefences: TypeDefenceModel
)