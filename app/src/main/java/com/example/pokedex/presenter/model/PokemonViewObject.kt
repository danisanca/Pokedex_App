package com.example.pokedex.presenter.model

import com.example.pokedex.data.model.BaseStatusRemoteModel
import com.example.pokedex.data.model.BreedingsRemoteModel
import com.example.pokedex.data.model.TrainingRemoteModel
import com.example.pokedex.data.model.TypeDefenceRemoteModel
import com.example.pokedex.domain.model.*

data class PokemonViewObject(
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
){
    constructor(pokemon:PokemonModel):this(
        id = pokemon.id,
        name = pokemon.name,
        image = pokemon.image,
        description = pokemon.description,
        height = pokemon.height,
        weight = pokemon.weight,
        species = pokemon.species,
        types = pokemon.types,
        training = pokemon.training,
        breeding = pokemon.breeding,
        baseStatus = pokemon.baseStatus,
        typeDefences = pokemon.typeDefences,
        )
}




