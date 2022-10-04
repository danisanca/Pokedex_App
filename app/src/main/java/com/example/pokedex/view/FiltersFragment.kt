package com.example.pokedex.view


import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFiltersBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FiltersFragment : BottomSheetDialogFragment(),View.OnClickListener {
   private lateinit var binding:FragmentFiltersBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFiltersBinding.inflate(layoutInflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bottomSheetBehavior = BottomSheetBehavior.from(view.parent as View)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        val layout = binding.bottomSheetLayout
        layout.minimumHeight = Resources.getSystem().displayMetrics.heightPixels
    }

    override fun onClick(v: View) {
       // Implementar Mudanças
    }


}