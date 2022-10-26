package com.example.pokedex.presenter.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.databinding.RowPokemonListBinding
import com.example.pokedex.presenter.listener.PokeListner
import com.example.pokedex.presenter.model.PokemonViewObject

class PokedexAdapter(
    private var listPokes: List<PokemonViewObject>,
    private val onClickRow: (PokemonViewObject) -> Unit,
) : RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = RowPokemonListBinding.inflate(inflater, parent, false)
        return PokedexViewHolder(itemBinding, parent.context)
    }

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {
        return holder.bindData(listPokes[position])
    }

    override fun getItemCount(): Int {
        return listPokes.count()
    }


    inner class PokedexViewHolder(
        private val binding: RowPokemonListBinding,
        private val context: Context,
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                onClickRow(listPokes[adapterPosition])
            }
        }

        fun bindData(poke: PokemonViewObject) {

            changeNumber(poke.id)
            binding.textPokeName.text = poke.name.replaceFirstChar { it.uppercase() }
            changeFormatName(poke.types)
            changeColor(poke)
            binding.imgPoke.load(poke.image)


        }

        fun changeNumber(id: Int) {

            if (id < 10) {
                binding.textPokeNumber.text = "#00" + id.toString()
            } else if (id >= 10 && id < 100) {
                binding.textPokeNumber.text = "#0" + id.toString()
            } else {
                binding.textPokeNumber.text = "#" + id.toString()
            }
        }

        fun changeFormatName(types: List<String>) {
            val sizeList = types.size

            if (sizeList == 2) {
                binding.typeOne.text = types[0].replaceFirstChar { it.uppercase() }
                binding.typeTwo.text = types[1].replaceFirstChar { it.uppercase() }
            } else {
                binding.typeOne.text = types[0].replaceFirstChar { it.uppercase() }
            }
        }

        fun changeColor(poke: PokemonViewObject) {
            val sizeList = poke.types.size

            if (sizeList == 2) {
                binding.typeOne.backgroundTintList =
                    ContextCompat.getColorStateList(context, poke.resourcesType[0].colorType)
                binding.typeTwo.backgroundTintList =
                    ContextCompat.getColorStateList(context, poke.resourcesType[1].colorType)
                binding.typeTwo.isVisible = true
                binding.typeOne.setCompoundDrawablesWithIntrinsicBounds(poke.resourcesType[0].icon,
                    0,
                    0,
                    0)
                binding.typeTwo.setCompoundDrawablesWithIntrinsicBounds(poke.resourcesType[1].icon,
                    0,
                    0,
                    0)
            } else {
                binding.typeOne.backgroundTintList =
                    ContextCompat.getColorStateList(context, poke.resourcesType[0].colorType)
                binding.typeOne.setCompoundDrawablesWithIntrinsicBounds(poke.resourcesType[0].icon,
                    0,
                    0,
                    0)
                binding.typeTwo.isVisible = false
            }
            binding.constBkgCard.backgroundTintList =
                ContextCompat.getColorStateList(context, poke.mainType.colorBackgroundType)
        }

    }

}