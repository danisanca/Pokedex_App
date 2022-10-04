package com.example.pokedex.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentSortBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SortFragment : BottomSheetDialogFragment() {
   private lateinit var binding: FragmentSortBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentSortBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


}