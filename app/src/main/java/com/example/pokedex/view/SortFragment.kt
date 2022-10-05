package com.example.pokedex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentSortBinding
import com.example.pokedex.service.constants.PokedexConstants
import com.example.pokedex.viewmodel.ListPokeViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.color.MaterialColors.getColor


class SortFragment : BottomSheetDialogFragment(),View.OnClickListener {
   private lateinit var binding: FragmentSortBinding
    private var itemSelected:Int? = null
    private val listButton:MutableList<Button> = mutableListOf<Button>()
    private val listViewModel: ListPokeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSortBinding.inflate(layoutInflater,container,false)
        genListItemsMenu()
        Observers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSmalllestNumberFirst.setOnClickListener(this)
        binding.btnHighestNumberFirst.setOnClickListener(this)
        binding.btnAToZ.setOnClickListener(this)
        binding.btnZToA.setOnClickListener(this)
    }
    private fun Observers(){
        listViewModel.filterSelected.observe(this, Observer { it ->
            if(it == PokedexConstants.MENUFILTER.SORT_OPTION){
                listViewModel.optionSelectedSort.observe(this, Observer {option->
                    when(option){
                        PokedexConstants.SORT.HIGHEST -> itemSelected =  binding.btnHighestNumberFirst.id
                        PokedexConstants.SORT.SMALLEST -> itemSelected =  binding.btnSmalllestNumberFirst.id
                        PokedexConstants.SORT.A_Z -> itemSelected =  binding.btnAToZ.id
                        PokedexConstants.SORT.Z_A -> itemSelected =  binding.btnZToA.id
                        else -> null
                    }
                    changeItemMenu(itemSelected!!)

                })
            }
        })
    }
    private fun changeItemMenu(itemBox:Int){

        listButton.map {
            if(it.id == itemBox){
                it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.backgroudInputSelected) }
                it.setTextColor(context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.white) })

            }else{
                it.backgroundTintList = context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.backgroudInput) }
                it.setTextColor(context?.let { it1 -> ContextCompat.getColorStateList(it1, R.color.textGray) })
            }
        }

    }

    private fun genListItemsMenu(){
        listButton.add(binding.btnSmalllestNumberFirst)
        listButton.add(binding.btnHighestNumberFirst)
        listButton.add(binding.btnAToZ)
        listButton.add(binding.btnZToA)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.btn_smalllest_number_first){
            itemSelected = binding.btnSmalllestNumberFirst.id
            listViewModel.menuSelectec(
                PokedexConstants.SORT.SMALLEST,
                PokedexConstants.MENUFILTER.SORT_OPTION)
        }
        if(v.id == R.id.btn_highest_number_first){
            itemSelected = binding.btnHighestNumberFirst.id
            listViewModel.menuSelectec(
                PokedexConstants.SORT.HIGHEST,
                PokedexConstants.MENUFILTER.SORT_OPTION)
        }
        if(v.id == R.id.btn_A_to_Z){
            itemSelected = binding.btnAToZ.id
            listViewModel.menuSelectec(
                PokedexConstants.SORT.A_Z,
                PokedexConstants.MENUFILTER.SORT_OPTION)
        }
        if(v.id == R.id.btn_Z_to_A){
            itemSelected = binding.btnZToA.id
            listViewModel.menuSelectec(
                PokedexConstants.SORT.Z_A,
                PokedexConstants.MENUFILTER.SORT_OPTION)
        }
        changeItemMenu(itemSelected!!)
    }

}