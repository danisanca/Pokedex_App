package com.example.pokedex.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.databinding.RowPokemonListBinding
import com.example.pokedex.service.model.Pokemon
import com.example.pokedex.view.viewholdel.PokeViewHolder

class PokeAdapter:RecyclerView.Adapter<PokeViewHolder>() {
        private var listPokes:List<Pokemon> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowPokemonListBinding.inflate(inflater,parent,false)
        return PokeViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: PokeViewHolder, position: Int) {
        return holder.bindData(listPokes[position])
    }

    override fun getItemCount(): Int {
        return listPokes.count()
    }
    fun updatePokedexList(list:List<Pokemon>){
        listPokes = list
        notifyDataSetChanged()
    }
}