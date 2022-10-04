package com.example.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentAboutBinding
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.viewmodel.AboutViewModel


class AboutFragment : Fragment() {

    private lateinit var aboutViewModel: AboutViewModel
    private var _binding: FragmentAboutBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        aboutViewModel = ViewModelProvider(this).get(AboutViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        _binding = FragmentAboutBinding.inflate(inflater, container, false)

       configDataActivity(poke)


        return binding.root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private var poke:PokemonModel = PokemonModel()
        @JvmStatic
        fun newInstance(sectionNumber: Int,objPoke:PokemonModel): AboutFragment {

            return AboutFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
                poke = objPoke
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun configDataActivity(poke:PokemonModel){

        binding.textPokeDescription.text = poke.description
        context?.let { binding.textPokedexData.setTextColor(it.getColor(typeColor(poke.types[0]))) }
        binding.textSpeciesValue.text = poke.species
        binding.textHeightValue.text = poke.height.toString()+"m"
        binding.textWeightValue.text = poke.weight.toString()+"Kg"
        context?.let { binding.textTraining.setTextColor(it.getColor(typeColor(poke.types[0]))) }
        binding.textEVYieldValue.text = poke.trainingModel.evYield
        binding.textCatchRateTextValue.text = poke.trainingModel.catchRateModel.value.toString()
        binding.textCatchRateValue.text = poke.trainingModel.catchRateModel.text
        binding.textBaseFriendshipTextValue.text = poke.trainingModel.baseFriendshipModel.value.toString()
        binding.textBaseFriendshipValue.text= poke.trainingModel.baseFriendshipModel.text
        binding.textBaseExpValue.text = poke.trainingModel.baseExp.toString()
        binding.textGrowthRateValue.text = poke.trainingModel.growthRate
        context?.let { binding.textBreeding.setTextColor(it.getColor(typeColor(poke.types[0]))) }

        binding.textEggCycleValue.text = poke.breeding.eggCyclesModel.value.toString()
        binding.textEggCycleTextValue.text = poke.breeding.eggCyclesModel.text
        binding.textMaleDescription.text = "♂ "+poke.breeding.genderModel.male.toString() + "%, "
        binding.textFemaleDescription.text = "♀ " + poke.breeding.genderModel.female+"%"
        if(poke.breeding.eggGroups.size > 1){
            binding.textEggGroupValue.text = "${poke.breeding.eggGroups[0].replaceFirstChar { it.uppercase() }} ${poke.breeding.eggGroups[1].replaceFirstChar { it.uppercase() }}"
        }else{
            binding.textEggGroupValue.text = poke.breeding.eggGroups[0].replaceFirstChar { it.uppercase() }
        }

    }

    private fun typeColor(color:String): Int {
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
            "male" -> return R.color.typeFlying
            "female" -> return R.color.typeFairy
            else -> return R.color.teal_200
        }
    }



}

