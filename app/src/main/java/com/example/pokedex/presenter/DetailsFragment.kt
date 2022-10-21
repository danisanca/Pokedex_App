package com.example.pokedex.presenter

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import coil.load
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentDetailsBinding
import com.example.pokedex.presenter.adapter.SectionsPagerAdapter
import com.example.pokedex.presenter.model.PokemonViewObject
import com.google.android.material.tabs.TabLayout
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!


    private lateinit var objPoke: PokemonViewObject
    private val args:DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        objPoke = args.pokemon
        _binding = FragmentDetailsBinding.inflate(layoutInflater,container,false)
        tabBar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configActivity()
    }


    private fun tabBar() {
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = SectionsPagerAdapter(this, parentFragmentManager, objPoke)
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)

    }
    private fun configActivity() {
        changeNumber(objPoke.id)
        binding.textPokeNameDetails.text = objPoke.name.replaceFirstChar { it.uppercase() }
        binding.imgPokeDetails.load(objPoke.image)
        changeNameType(objPoke.types)
        changeColor(objPoke.types)
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(requireContext(), backgroundTypeColor(objPoke.types[0]))))
    }

    private fun changeNumber(id: Int) {

        if (id < 10) {
            binding.textPokeNumberDetails.text = "#00" + id.toString()
        } else if (id >= 10 && id < 100) {
            binding.textPokeNumberDetails.text = "#0" + id.toString()
        } else {
            binding.textPokeNumberDetails.text = "#" + id.toString()
        }
    }

    fun changeNameType(types: List<String>) {
        val sizeList = types.size

        if (sizeList == 2) {
            binding.typeOneDetails.text = types[0].replaceFirstChar { it.uppercase() }
            binding.typeTwoDetails.text = types[1].replaceFirstChar { it.uppercase() }
        } else {
            binding.typeOneDetails.text = types[0].replaceFirstChar { it.uppercase() }
        }
    }

    fun typeIcon(color: String): Int {
        when (color) {
            "bug" -> return R.drawable.ic_bug
            "dark" -> return R.drawable.ic_dark
            "dragon" -> return R.drawable.ic_dragon
            "electric" -> return R.drawable.ic_electric
            "fairy" -> return R.drawable.ic_fairy
            "fighting" -> return R.drawable.ic_fighting
            "fire" -> return R.drawable.ic_fire
            "flying" -> return R.drawable.ic_flying
            "ghost" -> return R.drawable.ic_ghost
            "grass" -> return R.drawable.ic_grass
            "ground" -> return R.drawable.ic_ground
            "ice" -> return R.drawable.ic_ice
            "normal" -> return R.drawable.ic_normal
            "poison" -> return R.drawable.ic_poison
            "psychic" -> return R.drawable.ic_psychic
            "rock" -> return R.drawable.ic_rock
            "steel" -> return R.drawable.ic_steel
            "water" -> return R.drawable.ic_water
            else -> return R.color.teal_200
        }
    }

    fun changeColor(types: List<String>) {
        val sizeList = types.size
        var colorOne = ""
        var colorTwo = ""

        if (sizeList == 2) {
            colorOne = types[0]
            colorTwo = types[1]
            binding.typeOneDetails.backgroundTintList =
                ContextCompat.getColorStateList(requireContext(), typeColor(colorOne))
            binding.typeTwoDetails.backgroundTintList =
                ContextCompat.getColorStateList(requireContext(), typeColor(colorTwo))
            binding.typeOneDetails.setCompoundDrawablesWithIntrinsicBounds(
                typeIcon(colorOne),
                0,
                0,
                0
            )
            binding.typeTwoDetails.setCompoundDrawablesWithIntrinsicBounds(
                typeIcon(colorTwo),
                0,
                0,
                0
            )
            binding.typeTwoDetails.isVisible = true
        } else {
            colorOne = types[0]
            binding.typeOneDetails.backgroundTintList =
                ContextCompat.getColorStateList(requireContext(), typeColor(colorOne))
            binding.typeOneDetails.setCompoundDrawablesWithIntrinsicBounds(
                typeIcon(colorOne),
                0,
                0,
                0
            )
            binding.typeTwoDetails.isVisible = false
        }
        binding.appBarLayout.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), backgroundTypeColor(colorOne))
        binding.appbarMenu.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), backgroundTypeColor(colorOne))
        binding.viewPager.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(), backgroundTypeColor(colorOne))
    }

    fun typeColor(color: String): Int {
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

    fun backgroundTypeColor(color: String): Int {
        when (color) {
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}