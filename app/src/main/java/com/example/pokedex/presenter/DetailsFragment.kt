package com.example.pokedex.presenter

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
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
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        objPoke = args.pokemon
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        tabBar()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun tabBar() {
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = SectionsPagerAdapter(this, childFragmentManager, objPoke)
        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)
    }

    private fun configActivity() {
        changeNumber(objPoke.id)
        binding.textPokeNameDetails.text = objPoke.name.replaceFirstChar { it.uppercase() }
        binding.imgPokeDetails.load(objPoke.image)
        changeNameType(objPoke)
        changeColor(objPoke)
        (activity as AppCompatActivity).supportActionBar?.setBackgroundDrawable(ColorDrawable(
            ContextCompat.getColor(requireContext(), objPoke.resourcesType[0].colorBackgroundType)))
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

    fun changeNameType(poke: PokemonViewObject) {
        val sizeList = poke.types.size

        if (sizeList == 2) {
            binding.typeOneDetails.text = getString(poke.resourcesType[0].type)
            binding.typeTwoDetails.text = getString(poke.resourcesType[1].type)
        } else {
            binding.typeOneDetails.text = getString(poke.resourcesType[0].type)
        }
    }

    fun changeColor(poke: PokemonViewObject) {
        val sizeList = poke.types.size

        if (sizeList == 2) {
            binding.typeOneDetails.backgroundTintList =
                ContextCompat.getColorStateList(requireContext(), poke.resourcesType[0].colorType)
            binding.typeTwoDetails.backgroundTintList =
                ContextCompat.getColorStateList(requireContext(), poke.resourcesType[1].colorType)
            binding.typeOneDetails.setCompoundDrawablesWithIntrinsicBounds(poke.resourcesType[0].icon,
                0,
                0,
                0)
            binding.typeTwoDetails.setCompoundDrawablesWithIntrinsicBounds(poke.resourcesType[1].icon,
                0,
                0,
                0)
            binding.typeTwoDetails.isVisible = true
        } else {
            binding.typeOneDetails.backgroundTintList =
                ContextCompat.getColorStateList(requireContext(), poke.resourcesType[0].colorType)
            binding.typeOneDetails.setCompoundDrawablesWithIntrinsicBounds(poke.resourcesType[0].icon,
                0,
                0,
                0)
            binding.typeTwoDetails.isVisible = false
        }
        binding.appBarLayout.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(),
                poke.resourcesType[0].colorBackgroundType)
        binding.appbarMenu.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(),
                poke.resourcesType[0].colorBackgroundType)
        binding.viewPager.backgroundTintList =
            ContextCompat.getColorStateList(requireContext(),
                poke.resourcesType[0].colorBackgroundType)
    }
}