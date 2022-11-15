package com.example.pokedex.presenter.model

import android.os.Parcelable
import com.example.pokedex.domain.model.PokemonModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonViewObject(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val height: Float,
    val weight: Float,
    val species: String,
    val types: List<String>,
    val training: Training,
    val breeding: Breedings,
    val baseStatus: BaseStatus,
    val typeDefences: TypeDefence,
    val resourcesType: List<PokemonResources>,
    val mainType: PokemonResources,
) : Parcelable {
    constructor(pokemon: PokemonModel) : this(
        id = pokemon.id,
        name = pokemon.name,
        image = pokemon.image,
        description = pokemon.description,
        height = pokemon.height,
        weight = pokemon.weight,
        species = pokemon.species,
        types = pokemon.types,
        training = trainingToDomain(pokemon.training),
        breeding = breedingsToDomain(pokemon.breeding),
        baseStatus = baseStatusToDomain(pokemon.baseStatus),
        typeDefences = typeDefenceToDomain(pokemon.typeDefences),
        resourcesType = pokemon.types.map { pokemon ->
            PokemonResources.getPokemonType(pokemon)
        },
        mainType = PokemonResources.getPokemonType(pokemon.types[0])
    )
}