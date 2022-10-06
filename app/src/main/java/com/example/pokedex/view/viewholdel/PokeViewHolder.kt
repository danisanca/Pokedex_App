package com.example.pokedex.view.viewholdel

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pokedex.R
import com.example.pokedex.databinding.RowPokemonListBinding
import com.example.pokedex.service.listener.PokeListner
import com.example.pokedex.service.model.PokemonModel
import java.util.*

class PokeViewHolder (private val binding: RowPokemonListBinding, private val context: Context, val listner: PokeListner):RecyclerView.ViewHolder(binding.root){
    fun bindData(poke:PokemonModel){

        changeNumber(poke.id)
        binding.textPokeName.text = poke.name.replaceFirstChar { it.uppercase() }
        changeNameType(poke.types)
        changeColor(poke.types)
        binding.imgPoke.load(poke.image)

        // - Eventos

        binding.imgPoke.setOnClickListener{
            listner.onListClick(poke)
        }

    }

    fun changeNumber(id:Int){

        if(id<10){
            binding.textPokeNumber.text = "#00" + id.toString()
        }else if(id>=10 && id <100){
            binding.textPokeNumber.text = "#0" +id.toString()
        }else{
            binding.textPokeNumber.text = "#"+id.toString()
        }

    }

    fun changeNameType(types:List<String>){
        val sizeList = types.size

        if(sizeList == 2){
            binding.typeOne.text = types[0].replaceFirstChar { it.uppercase() }
            binding.typeTwo.text = types[1].replaceFirstChar { it.uppercase() }
        }else{
            binding.typeOne.text = types[0].replaceFirstChar { it.uppercase() }
        }
    }

    fun changeColor(types:List<String>){
        val sizeList = types.size
        var colorOne = ""
        var colorTwo = ""

        if(sizeList == 2){
            colorOne = types[0]
            colorTwo = types[1]
            binding.typeOne.backgroundTintList = ContextCompat.getColorStateList(context, typeColor(colorOne))
            binding.typeTwo.backgroundTintList = ContextCompat.getColorStateList(context, typeColor(colorTwo))
            binding.typeTwo.isVisible = true
            binding.typeOne.setCompoundDrawablesWithIntrinsicBounds(typeIcon(colorOne),0,0,0)
            binding.typeTwo.setCompoundDrawablesWithIntrinsicBounds(typeIcon(colorTwo),0,0,0)
        }else{
            colorOne = types[0]
            binding.typeOne.backgroundTintList = ContextCompat.getColorStateList(context, typeColor(colorOne))
            binding.typeOne.setCompoundDrawablesWithIntrinsicBounds(typeIcon(colorOne),0,0,0)
             binding.typeTwo.isVisible = false
        }

        binding.constBkgCard.backgroundTintList = ContextCompat.getColorStateList(context, backgroundTypeColor(colorOne))

    }

    fun typeIcon(color:String):Int {
        when(color){
            "bug" -> return R.drawable.ic_bug_effect
            "dark" -> return R.drawable.ic_dark_effect
            "dragon" -> return R.drawable.ic_dragon_effect
            "electric" -> return R.drawable.ic_electric_effect
            "fairy" -> return R.drawable.ic_fairy_effect
            "fighting" -> return R.drawable.ic_fighting_effect
            "fire" -> return R.drawable.ic_fire_effect
            "flying" -> return R.drawable.ic_flying_effect
            "ghost" -> return R.drawable.ic_ghost_effect
            "grass" -> return R.drawable.ic_grass_effect
            "ground" -> return R.drawable.ic_ground_effect
            "ice" -> return R.drawable.ic_ice_effect
            "normal" -> return R.drawable.ic_normal_effect
            "poison" -> return R.drawable.ic_poison
            "psychic" -> return R.drawable.ic_psychic_effect
            "rock" -> return R.drawable.ic_rock_effect
            "steel" -> return R.drawable.ic_steel_effect
            "water" -> return R.drawable.ic_water_effect
            else -> return R.color.teal_200
        }
    }

    fun typeColor(color:String): Int {
       when(color){
           "bug" -> return R.color.typeBug
           "dark" -> return R.color.typeDark
           "dragon" -> return R.color.typeDragon
           "electric" -> return R.color.typeElectric
           "fairy" -> return R.color.typeFairy
           "fighting" -> return R.color.typeFighting
           "fire" -> return R.color.typeFire
           "flying" -> return R.color.typeFlying
           "ghost" -> return R.color.typeGhost
           "grass" -> return R.color.typeGrass
           "ground" -> return R.color.typeGround
           "ice" -> return R.color.typeIce
           "normal" -> return R.color.typeNormal
           "poison" -> return R.color.typePoison
           "psychic" -> return R.color.typePsychic
           "rock" -> return R.color.typeRock
           "steel" -> return R.color.typeSteel
           "water" -> return R.color.typeWater
           else -> return R.color.teal_200
       }
    }

    fun backgroundTypeColor(color:String): Int {
        when(color){
            "bug" -> return R.color.bkgTypeBug
            "dark" -> return R.color.bkgTypeDark
            "dragon" -> return R.color.bkgTypeDragon
            "electric" -> return R.color.bkgTypeElectric
            "fairy" -> return R.color.bkgTypeFairy
            "fighting" -> return R.color.bkgTypeFighting
            "fire" -> return R.color.bkgTypeFire
            "flying" -> return R.color.bkgTypeFlying
            "ghost" -> return R.color.bkgTypeGhost
            "grass" -> return R.color.bkgTypeGrass
            "ground" -> return R.color.bkgTypeGround
            "ice" -> return R.color.bkgTypeIce
            "normal" -> return R.color.bkgTypeNormal
            "poison" -> return R.color.bkgTypePoison
            "psychic" -> return R.color.bkgTypePsychic
            "rock" -> return R.color.bkgTypeRock
            "steel" -> return R.color.bkgTypeSteel
            "water" -> return R.color.bkgTypeWater
            else -> return R.color.teal_200
        }
    }


}