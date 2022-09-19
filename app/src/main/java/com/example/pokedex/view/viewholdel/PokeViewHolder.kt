package com.example.pokedex.view.viewholdel

import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.RowPokemonListBinding
import com.example.pokedex.service.model.Pokemon

class PokeViewHolder (private val binding:RowPokemonListBinding):RecyclerView.ViewHolder(binding.root){
    fun bindData(poke:Pokemon){

        binding.textPokeNumber.text = poke.id.toString()
        binding.textPokeName.text = poke.name
        binding.typeOne.text = "Grass"
        binding.typeTwo.text = "Grass"

    }
}