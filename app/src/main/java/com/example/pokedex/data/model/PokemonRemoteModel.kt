package com.example.pokedex.data.model

import com.example.pokedex.domain.model.*
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonRemoteModel(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("description") val description: String,
    @SerializedName("height") val height: Float,
    @SerializedName("weight") val weight: Float,
    @SerializedName("species") val species: String,
    @SerializedName("types") val types: List<String>,
    @SerializedName("training") val training: TrainingRemoteModel,
    @SerializedName("breedings") val breeding: BreedingsRemoteModel,
    @SerializedName("baseStats") val baseStatus: BaseStatusRemoteModel,
    @SerializedName("typeDefences") val typeDefences: TypeDefenceRemoteModel
)

fun PokemonRemoteModel.toDomain() = PokemonModel(
    id = this.id,
    name = this.name,
    image = this.image,
    description = this.description,
    height = this.height,
    weight = this.weight,
    species = this.species,
    types = this.types,
    training = this.training,
    breeding = this.breeding,
    baseStatus = this.baseStatus,
    typeDefences = this.typeDefences
)



