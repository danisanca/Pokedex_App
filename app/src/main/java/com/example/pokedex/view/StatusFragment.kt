package com.example.pokedex.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentStatusBinding
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.viewmodel.StatusViewModel
import java.text.DecimalFormat


class StatusFragment : Fragment() {

    private lateinit var pageViewModel: StatusViewModel
    private var _binding: FragmentStatusBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pageViewModel = ViewModelProvider(this).get(StatusViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        _binding = FragmentStatusBinding.inflate(inflater, container, false)
        configDataActivity(poke)


        return binding.root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"
        private var poke: PokemonModel = PokemonModel()
        @JvmStatic
        fun newInstance(sectionNumber: Int,objPoke:PokemonModel): StatusFragment {

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

    private fun configDataActivity(poke:PokemonModel){
        context?.let { binding.textBaseStatusData.setTextColor(it.getColor(typeColor(poke.types[0])))}
        context?.let { binding.textTypeDefenses.setTextColor(it.getColor(typeColor(poke.types[0])))}
        changeProgressColor(poke.types[0])
        changeProgress()
        changeProgressText()
        changeTypeDefense()
    }
    private fun changeProgressText(){
        binding.textHpValue.text = poke.baseStatusModel.hp[0].toString()
        binding.textHpMinValue.text = poke.baseStatusModel.hp[1].toString()
        binding.textHpMaxValue.text = poke.baseStatusModel.hp[2].toString()

        binding.textAttackValue.text = poke.baseStatusModel.attack[0].toString()
        binding.textAttackMinValue.text = poke.baseStatusModel.attack[1].toString()
        binding.textAttackMaxValue.text = poke.baseStatusModel.attack[2].toString()

        binding.textDefenceValue.text = poke.baseStatusModel.defence[0].toString()
        binding.textDefenceMinValue.text = poke.baseStatusModel.defence[1].toString()
        binding.textDefenceMaxValue.text = poke.baseStatusModel.defence[2].toString()

        binding.textSpAtkValue.text = poke.baseStatusModel.specialAttack[0].toString()
        binding.textSpAtkMinValue.text = poke.baseStatusModel.specialAttack[1].toString()
        binding.textSpAtkMaxValue.text = poke.baseStatusModel.specialAttack[2].toString()

        binding.textSpDefValue.text = poke.baseStatusModel.specialDefence[0].toString()
        binding.textSpDefMinValue.text = poke.baseStatusModel.specialDefence[1].toString()
        binding.textSpDefMaxValue.text = poke.baseStatusModel.specialDefence[2].toString()

        binding.textSpeedValue.text = poke.baseStatusModel.speed[0].toString()
        binding.textSpeedMinValue.text = poke.baseStatusModel.speed[1].toString()
        binding.textSpeedMaxValue.text = poke.baseStatusModel.speed[2].toString()

        val sum = poke.baseStatusModel.hp[0] + poke.baseStatusModel.attack[0] +poke.baseStatusModel.defence[0]+
                poke.baseStatusModel.specialAttack[0]+poke.baseStatusModel.specialDefence[0]+ poke.baseStatusModel.speed[0]

        binding.textTotalValue.text = sum.toString()
    }

    private fun changeProgress(){
        binding.progressbarHp.setProgress(poke.baseStatusModel.hp[0])
        binding.progressbarHp.max = poke.baseStatusModel.hp[2]
        binding.progressbarAttack.setProgress(poke.baseStatusModel.attack[0])
        binding.progressbarAttack.max = poke.baseStatusModel.attack[2]
        binding.progressbarDefence.setProgress(poke.baseStatusModel.defence[0])
        binding.progressbarDefence.max = poke.baseStatusModel.defence[2]
        binding.progressbarSpAtk.setProgress(poke.baseStatusModel.specialAttack[0])
        binding.progressbarSpAtk.max = poke.baseStatusModel.specialAttack[2]
        binding.progressbarSpDef.setProgress(poke.baseStatusModel.specialDefence[0])
        binding.progressbarSpDef.max = poke.baseStatusModel.specialDefence[2]
        binding.progressbarSpSpeed.setProgress(poke.baseStatusModel.speed[0])
        binding.progressbarSpSpeed.max = poke.baseStatusModel.speed[2]


    }

    private fun changeProgressColor(color:String){
        binding.progressbarHp.progressTintList = context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarAttack.progressTintList = context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarDefence.progressTintList = context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarSpAtk.progressTintList = context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarSpDef.progressTintList = context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
        binding.progressbarSpSpeed.progressTintList = context?.let { ContextCompat.getColorStateList(it, typeColor(poke.types[0])) }
    }

    private fun changeTypeDefense(){
        binding.textIcNormalEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.normal)
        binding.textIcFireEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.fire)
        binding.textIcWaterEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.water)
        binding.textIcElectricEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.electric)
        binding.textIcGrassEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.grass)
        binding.textIcIceEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.ice)
        binding.textIcFightingEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.fighting)
        binding.textIcPoisonEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.poison)
        binding.textIcGroundEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.ground)
        binding.textIcFlyingEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.flying)
        binding.textIcPsychicEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.psychic)
        binding.textIcBugEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.bug)
        binding.textIcRockEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.rock)
        binding.textIcGhostEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.ghost)
        binding.textIcDragonEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.dragon)
        binding.textIcDarkEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.dark)
        binding.textIcSteelEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.steel)
        binding.textIcFairyEffectivyValue.text = customTextTypeDefence(poke.typeDefencesModel.fairy)

    }
    private fun customTextTypeDefence(value:Float):String{
        if(value < 1 ){
            return when(value){
                0.25f -> "¼"
                0.5f -> "½"
                else -> ""
            }
        }
        else if(value <= 0){
            return ""
        }
        else{
            val dec = DecimalFormat("#")
            return dec.format(value).toString()
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
            else -> return R.color.teal_200
        }
    }
}