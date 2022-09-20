package com.example.pokedex.view.viewholdel

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.databinding.RowPokemonListBinding
import com.example.pokedex.service.model.Pokemon

class PokeViewHolder (private val binding:RowPokemonListBinding,private val context: Context):RecyclerView.ViewHolder(binding.root){
    fun bindData(poke:Pokemon){

        changeNumber(poke.id)
        binding.textPokeName.text = poke.name
        changeNameType(poke.types)
        changeColor(poke.types)
//        binding.typeOne.text = "Grass"
//        binding.typeTwo.text = "Grass"


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
            binding.typeOne.text = types[0]
            binding.typeTwo.text = types[1]
        }else{
            binding.typeOne.text = types[0]
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
        }else{
            colorOne = types[0]
            binding.typeOne.backgroundTintList = ContextCompat.getColorStateList(context, typeColor(colorOne))
            binding.typeTwo.isVisible = false
        }
        binding.constBkgCard.backgroundTintList = ContextCompat.getColorStateList(context, backgroundTypeColor(colorOne))

    }

    fun typeColor(color:String): Int {
       when(color){
           "Bug" -> return R.color.typeBug
           "Dark" -> return R.color.typeDark
           "Dragon" -> return R.color.typeDragon
           "Electric" -> return R.color.typeElectric
           "Fairy" -> return R.color.typeFairy
           "Fighting" -> return R.color.typeFighting
           "Fire" -> return R.color.typeFire
           "Flying" -> return R.color.typeFlying
           "Ghost" -> return R.color.typeGhost
           "Grass" -> return R.color.typeGrass
           "Ground" -> return R.color.typeGround
           "Ice" -> return R.color.typeIce
           "Normal" -> return R.color.typeNormal
           "Poison" -> return R.color.typePoison
           "Psychic" -> return R.color.typePsychic
           "Rock" -> return R.color.typeRock
           "Steel" -> return R.color.typeSteel
           "Water" -> return R.color.typeWater
           else -> return R.color.white
       }
    }
    fun backgroundTypeColor(color:String): Int {
        when(color){
            "Bug" -> return R.color.bkgTypeBug
            "Dark" -> return R.color.bkgTypeDark
            "Dragon" -> return R.color.bkgTypeDragon
            "Electric" -> return R.color.bkgTypeElectric
            "Fairy" -> return R.color.bkgTypeFairy
            "Fighting" -> return R.color.bkgTypeFighting
            "Fire" -> return R.color.bkgTypeFire
            "Flying" -> return R.color.bkgTypeFlying
            "Ghost" -> return R.color.bkgTypeGhost
            "Grass" -> return R.color.bkgTypeGrass
            "Ground" -> return R.color.bkgTypeGround
            "Ice" -> return R.color.bkgTypeIce
            "Normal" -> return R.color.bkgTypeNormal
            "Poison" -> return R.color.bkgTypePoison
            "Psychic" -> return R.color.bkgTypePsychic
            "Rock" -> return R.color.bkgTypeRock
            "Steel" -> return R.color.bkgTypeSteel
            "Water" -> return R.color.bkgTypeWater
            else -> return R.color.white
        }
    }

}