package com.example.pokedex.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentStatusBinding
import com.example.pokedex.domain.model.PokemonModel
import com.example.pokedex.presenter.model.PokemonViewObject
import com.example.pokedex.presenter.viewmodel.PokeDetailsViewModel
import java.text.DecimalFormat


class StatusFragment : Fragment() {

    private lateinit var pageViewModel: PokeDetailsViewModel
    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pageViewModel = ViewModelProvider(this).get(PokeDetailsViewModel::class.java).apply {
            setIndexStatus(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)

        configDataActivity()
        return binding.root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private lateinit var poke: PokemonViewObject
        @JvmStatic
        fun newInstance(sectionNumber: Int,objPoke: PokemonViewObject): StatusFragment {

            return StatusFragment().apply {
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
        context?.let { binding.textBaseStatusData.setTextColor(it.getColor(typeColor(poke.types[0]))) }
        context?.let { binding.textTypeDefenses.setTextColor(it.getColor(typeColor(poke.types[0]))) }
        changeProgressColor(poke.types[0])
        changeProgress()
        changeProgressText()
        changeTypeDefense()
    }

    private fun changeProgressText() {
        binding.textHpValue.text = poke.baseStatus.hp[0].toString()
        binding.textHpMinValue.text = poke.baseStatus.hp[1].toString()
        binding.textHpMaxValue.text = poke.baseStatus.hp[2].toString()

        binding.textAttackValue.text = poke.baseStatus.attack[0].toString()
        binding.textAttackMinValue.text = poke.baseStatus.attack[1].toString()
        binding.textAttackMaxValue.text = poke.baseStatus.attack[2].toString()

        binding.textDefenceValue.text = poke.baseStatus.defence[0].toString()
        binding.textDefenceMinValue.text = poke.baseStatus.defence[1].toString()
        binding.textDefenceMaxValue.text = poke.baseStatus.defence[2].toString()

        binding.textSpAtkValue.text = poke.baseStatus.specialAttack[0].toString()
        binding.textSpAtkMinValue.text = poke.baseStatus.specialAttack[1].toString()
        binding.textSpAtkMaxValue.text = poke.baseStatus.specialAttack[2].toString()

        binding.textSpDefValue.text = poke.baseStatus.specialDefence[0].toString()
        binding.textSpDefMinValue.text = poke.baseStatus.specialDefence[1].toString()
        binding.textSpDefMaxValue.text = poke.baseStatus.specialDefence[2].toString()

        binding.textSpeedValue.text = poke.baseStatus.speed[0].toString()
        binding.textSpeedMinValue.text = poke.baseStatus.speed[1].toString()
        binding.textSpeedMaxValue.text = poke.baseStatus.speed[2].toString()

        val sum =
            poke.baseStatus.hp[0] + poke.baseStatus.attack[0] + poke.baseStatus.defence[0] +
                    poke.baseStatus.specialAttack[0] + poke.baseStatus.specialDefence[0] + poke.baseStatus.speed[0]

        binding.textTotalValue.text = sum.toString()
    }

    private fun changeProgress() {
        binding.progressbarHp.setProgress(poke.baseStatus.hp[0])
        binding.progressbarHp.max = poke.baseStatus.hp[2]
        binding.progressbarAttack.setProgress(poke.baseStatus.attack[0])
        binding.progressbarAttack.max = poke.baseStatus.attack[2]
        binding.progressbarDefence.setProgress(poke.baseStatus.defence[0])
        binding.progressbarDefence.max = poke.baseStatus.defence[2]
        binding.progressbarSpAtk.setProgress(poke.baseStatus.specialAttack[0])
        binding.progressbarSpAtk.max = poke.baseStatus.specialAttack[2]
        binding.progressbarSpDef.setProgress(poke.baseStatus.specialDefence[0])
        binding.progressbarSpDef.max = poke.baseStatus.specialDefence[2]
        binding.progressbarSpSpeed.setProgress(poke.baseStatus.speed[0])
        binding.progressbarSpSpeed.max = poke.baseStatus.speed[2]

    }

    private fun changeProgressColor(color: String) {
        binding.progressbarHp.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarAttack.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarDefence.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarSpAtk.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarSpDef.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarSpSpeed.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
    }

    private fun changeTypeDefense() {
        binding.textIcNormalEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.normal)
        binding.textIcFireEffectivyValue.text = customTextTypeDefence(poke.typeDefences.fire)
        binding.textIcWaterEffectivyValue.text = customTextTypeDefence(poke.typeDefences.water)
        binding.textIcElectricEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.electric)
        binding.textIcGrassEffectivyValue.text = customTextTypeDefence(poke.typeDefences.grass)
        binding.textIcIceEffectivyValue.text = customTextTypeDefence(poke.typeDefences.ice)
        binding.textIcFightingEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.fighting)
        binding.textIcPoisonEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.poison)
        binding.textIcGroundEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.ground)
        binding.textIcFlyingEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.flying)
        binding.textIcPsychicEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.psychic)
        binding.textIcBugEffectivyValue.text = customTextTypeDefence(poke.typeDefences.bug)
        binding.textIcRockEffectivyValue.text = customTextTypeDefence(poke.typeDefences.rock)
        binding.textIcGhostEffectivyValue.text = customTextTypeDefence(poke.typeDefences.ghost)
        binding.textIcDragonEffectivyValue.text =
            customTextTypeDefence(poke.typeDefences.dragon)
        binding.textIcDarkEffectivyValue.text = customTextTypeDefence(poke.typeDefences.dark)
        binding.textIcSteelEffectivyValue.text = customTextTypeDefence(poke.typeDefences.steel)
        binding.textIcFairyEffectivyValue.text = customTextTypeDefence(poke.typeDefences.fairy)
    }

    private fun customTextTypeDefence(value: Float): String {
        if (value < 1) {
            return when (value) {
                0.25f -> "¼"
                0.5f -> "½"
                else -> ""
            }
        } else if (value <= 0) {
            return ""
        } else {
            val dec = DecimalFormat("#")
            return dec.format(value).toString()
        }

    }

    private fun typeColor(color: String): Int {
        when (color) {
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
}