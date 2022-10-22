package com.example.pokedex.presenter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.pokedex.databinding.FragmentStatusBinding
import com.example.pokedex.presenter.model.PokemonViewObject
import java.text.DecimalFormat


class StatusFragment : Fragment() {

    private var _binding: FragmentStatusBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)

        configDataActivity()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private lateinit var poke: PokemonViewObject

        @JvmStatic
        fun newInstance(sectionNumber: Int, objPoke: PokemonViewObject): StatusFragment {

            return StatusFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
                poke = objPoke
            }
        }
    }

    private fun configDataActivity() {
        context?.let { binding.textBaseStatusData.setTextColor(it.getColor(poke.resourcesType[0].colorType)) }
        context?.let { binding.textTypeDefenses.setTextColor(it.getColor(poke.resourcesType[0].colorType)) }
        changeProgressColor()
        changeProgress()
        changeProgressText()
        changeTypeDefense()
    }

    private fun changeProgressText() {

        val totalStatus =
            poke.baseStatus.hp[0] + poke.baseStatus.attack[0] + poke.baseStatus.defence[0] +
                    poke.baseStatus.specialAttack[0] + poke.baseStatus.specialDefence[0] + poke.baseStatus.speed[0]

        binding.textTotalValue.text = totalStatus.toString()

        binding.apply {
            textHpValue.text = poke.baseStatus.hp[0].toString()
            textHpMinValue.text = poke.baseStatus.hp[1].toString()
            textHpMaxValue.text = poke.baseStatus.hp[2].toString()

            textAttackValue.text = poke.baseStatus.attack[0].toString()
            textAttackMinValue.text = poke.baseStatus.attack[1].toString()
            textAttackMaxValue.text = poke.baseStatus.attack[2].toString()

            textDefenceValue.text = poke.baseStatus.defence[0].toString()
            textDefenceMinValue.text = poke.baseStatus.defence[1].toString()
            textDefenceMaxValue.text = poke.baseStatus.defence[2].toString()

            textSpAtkValue.text = poke.baseStatus.specialAttack[0].toString()
            textSpAtkMinValue.text = poke.baseStatus.specialAttack[1].toString()
            textSpAtkMaxValue.text = poke.baseStatus.specialAttack[2].toString()

            textSpDefValue.text = poke.baseStatus.specialDefence[0].toString()
            textSpDefMinValue.text = poke.baseStatus.specialDefence[1].toString()
            textSpDefMaxValue.text = poke.baseStatus.specialDefence[2].toString()

            textSpeedValue.text = poke.baseStatus.speed[0].toString()
            textSpeedMinValue.text = poke.baseStatus.speed[1].toString()
            textSpeedMaxValue.text = poke.baseStatus.speed[2].toString()
        }
    }

    private fun changeProgress() {
        binding.apply {
            progressbarHp.setProgress(poke.baseStatus.hp[0])
            progressbarHp.max = poke.baseStatus.hp[2]
            progressbarAttack.setProgress(poke.baseStatus.attack[0])
            progressbarAttack.max = poke.baseStatus.attack[2]
            progressbarDefence.setProgress(poke.baseStatus.defence[0])
            progressbarDefence.max = poke.baseStatus.defence[2]
            progressbarSpAtk.setProgress(poke.baseStatus.specialAttack[0])
            progressbarSpAtk.max = poke.baseStatus.specialAttack[2]
            progressbarSpDef.setProgress(poke.baseStatus.specialDefence[0])
            progressbarSpDef.max = poke.baseStatus.specialDefence[2]
            progressbarSpSpeed.setProgress(poke.baseStatus.speed[0])
            progressbarSpSpeed.max = poke.baseStatus.speed[2]
        }
    }

    private fun changeProgressColor() {
        binding.progressbarHp.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, poke.resourcesType[0].colorType) }
        binding.progressbarAttack.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, poke.resourcesType[0].colorType) }
        binding.progressbarDefence.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, poke.resourcesType[0].colorType) }
        binding.progressbarSpAtk.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, poke.resourcesType[0].colorType) }
        binding.progressbarSpDef.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, poke.resourcesType[0].colorType) }
        binding.progressbarSpSpeed.progressTintList =
            context?.let { ContextCompat.getColorStateList(it, poke.resourcesType[0].colorType) }
    }

    private fun changeTypeDefense() {
        binding.apply {
            textIcNormalEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.normal)
            textIcFireEffectivyValue.text = customTextTypeDefence(poke.typeDefences.fire)
            textIcWaterEffectivyValue.text = customTextTypeDefence(poke.typeDefences.water)
            textIcElectricEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.electric)
            textIcGrassEffectivyValue.text = customTextTypeDefence(poke.typeDefences.grass)
            textIcIceEffectivyValue.text = customTextTypeDefence(poke.typeDefences.ice)
            textIcFightingEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.fighting)
            textIcPoisonEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.poison)
            textIcGroundEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.ground)
            textIcFlyingEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.flying)
            textIcPsychicEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.psychic)
            textIcBugEffectivyValue.text = customTextTypeDefence(poke.typeDefences.bug)
            textIcRockEffectivyValue.text = customTextTypeDefence(poke.typeDefences.rock)
            textIcGhostEffectivyValue.text = customTextTypeDefence(poke.typeDefences.ghost)
            textIcDragonEffectivyValue.text =
                customTextTypeDefence(poke.typeDefences.dragon)
            textIcDarkEffectivyValue.text = customTextTypeDefence(poke.typeDefences.dark)
            textIcSteelEffectivyValue.text = customTextTypeDefence(poke.typeDefences.steel)
            textIcFairyEffectivyValue.text = customTextTypeDefence(poke.typeDefences.fairy)
        }
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
}