package com.example.pokedex.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedex.databinding.FragmentAboutBinding
import com.example.pokedex.presenter.model.PokemonViewObject


class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        configDataActivity()

        return binding.root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private lateinit var poke: PokemonViewObject

        @JvmStatic
        fun newInstance(sectionNumber: Int, objPoke: PokemonViewObject): AboutFragment {

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

    private fun configDataActivity() {

        binding.apply {
            textPokeDescription.text = poke.description
            context?.let { textPokedexData.setTextColor(it.getColor(poke.resourcesType[0].colorType)) }
            textSpeciesValue.text = poke.species
            textHeightValue.text = poke.height.toString() + "m"
            textWeightValue.text = poke.weight.toString() + "Kg"
            context?.let { textTraining.setTextColor(it.getColor(poke.resourcesType[0].colorType)) }
            textEVYieldValue.text = poke.training.evYield
            textCatchRateTextValue.text = poke.training.catchRate.value.toString()
            textCatchRateValue.text = poke.training.catchRate.text
            textBaseFriendshipTextValue.text = poke.training.baseFriendship.value.toString()
            textBaseFriendshipValue.text = poke.training.baseFriendship.text
            textBaseExpValue.text = poke.training.baseExp.toString()
            textGrowthRateValue.text = poke.training.growthRate
            context?.let { textBreeding.setTextColor(it.getColor(poke.resourcesType[0].colorType)) }

            textEggCycleValue.text = poke.breeding.eggCyclesModel.value.toString()
            textEggCycleTextValue.text = poke.breeding.eggCyclesModel.text
            textMaleDescription.text = "♂ " + poke.breeding.genderModel.male.toString() + "%, "
            textFemaleDescription.text = "♀ " + poke.breeding.genderModel.female + "%"
        }

        if (poke.breeding.eggGroups.size > 1) {
            binding.textEggGroupValue.text =
                "${poke.breeding.eggGroups[0].replaceFirstChar { it.uppercase() }} ${poke.breeding.eggGroups[1].replaceFirstChar { it.uppercase() }}"
        } else {
            binding.textEggGroupValue.text =
                poke.breeding.eggGroups[0].replaceFirstChar { it.uppercase() }
        }

    }
}

