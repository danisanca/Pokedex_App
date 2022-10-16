package com.example.pokedex.presenter

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentGenerationsBinding
import com.example.pokedex.presenter.constants.PokedexConstants
import com.example.pokedex.presenter.viewmodel.ListPokeViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenerationsFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentGenerationsBinding
    private var itemSelected: Int? = null
    private val listBoxItems: MutableList<ImageView> = mutableListOf<ImageView>()
    private val listViewModel: ListPokeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL,R.style.BottomSheetDialog)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenerationsBinding.inflate(layoutInflater)
        genListItemsMenu()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        val layout = binding.bottomSheetLayout
        layout.minimumHeight = Resources.getSystem().displayMetrics.heightPixels

        binding.boxOneGen.setOnClickListener{
            itemSelected = binding.boxOneGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_1,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxSecondGen.setOnClickListener{
            itemSelected = binding.boxSecondGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_2,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxThirdGen.setOnClickListener{
            itemSelected = binding.boxThirdGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_3,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxFourGen.setOnClickListener{
            itemSelected = binding.boxFourGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_4,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxFiveGen.setOnClickListener{
            itemSelected = binding.boxFiveGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_5,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxSixGen.setOnClickListener{
            itemSelected = binding.boxSixGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_6,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxSevenGen.setOnClickListener{
            itemSelected = binding.boxSevenGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_7,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        binding.boxEightGen.setOnClickListener{
            itemSelected = binding.boxEightGen.id
            listViewModel.menuSelectec(
                PokedexConstants.GENERATION.GEN_8,
                PokedexConstants.MENUFILTER.GENERATION_OPTION
            )
            changeItemMenu(itemSelected)
            dismiss()
        }
        Observers()
    }

    private fun Observers() {
        listViewModel.filterSelected.observe(this, Observer { it ->
            if (it == PokedexConstants.MENUFILTER.GENERATION_OPTION) {
                listViewModel.optionSelectedGeneretion.observe(this, Observer { option ->
                    when (option) {
                        PokedexConstants.GENERATION.GEN_1 -> itemSelected = binding.boxOneGen.id
                        PokedexConstants.GENERATION.GEN_2 -> itemSelected = binding.boxSecondGen.id
                        PokedexConstants.GENERATION.GEN_3 -> itemSelected = binding.boxThirdGen.id
                        PokedexConstants.GENERATION.GEN_4 -> itemSelected = binding.boxFourGen.id
                        PokedexConstants.GENERATION.GEN_5 -> itemSelected = binding.boxFiveGen.id
                        PokedexConstants.GENERATION.GEN_6 -> itemSelected = binding.boxSixGen.id
                        PokedexConstants.GENERATION.GEN_7 -> itemSelected = binding.boxSevenGen.id
                        PokedexConstants.GENERATION.GEN_8 -> itemSelected = binding.boxEightGen.id
                        else -> null
                    }
                    changeItemMenu(itemSelected)
                })
            }
        })
    }

    private fun changeItemMenu(itemBox: Int?) {

        if (itemBox != null) {

            listBoxItems.map {
                if (it.id == itemBox) {
                    it.backgroundTintList = context?.let { it1 ->
                        ContextCompat.getColorStateList(
                            it1,
                            R.color.backgroudInputSelected
                        )
                    }
                } else {
                    it.backgroundTintList = context?.let { it1 ->
                        ContextCompat.getColorStateList(
                            it1,
                            R.color.backgroudInput
                        )
                    }
                }
            }

        }
    }

    private fun genListItemsMenu() {
        listBoxItems.add(binding.boxOneGen)
        listBoxItems.add(binding.boxSecondGen)
        listBoxItems.add(binding.boxThirdGen)
        listBoxItems.add(binding.boxFourGen)
        listBoxItems.add(binding.boxFiveGen)
        listBoxItems.add(binding.boxSixGen)
        listBoxItems.add(binding.boxSevenGen)
        listBoxItems.add(binding.boxEightGen)
    }
}
