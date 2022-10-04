package com.example.pokedex.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentListPokeBinding
import com.example.pokedex.service.listener.PokeListner
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.view.adapter.PokeAdapter
import com.example.pokedex.viewmodel.ListPokeViewModel
import com.google.gson.Gson

class ListPokeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentListPokeBinding
    private lateinit var viewModel:ListPokeViewModel
    private val adapter = PokeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentListPokeBinding.inflate(layoutInflater,container,false)
        viewModel = ViewModelProvider(this)[ListPokeViewModel::class.java]

        viewModel.listPokes()

        binding.recyclerList.layoutManager = LinearLayoutManager(context)
        binding.recyclerList.adapter = adapter

        binding.btnGeneration.setOnClickListener(this)
        binding.btnFilter.setOnClickListener(this)
        binding.btnSort.setOnClickListener(this)

        observers()

        val listener = object : PokeListner{
            override fun onListClick(poke: PokemonModel) {
                val gson = Gson()
                val listPoke = gson.toJson(poke)
                startActivity(Intent(context,PokeDetailsActivity::class.java).putExtra("objPoke",listPoke))
            }
        }

        adapter.attachListener(listener)

        return binding.root
    }

    private fun observers() {
        viewModel.pokemonModel.observe(viewLifecycleOwner){
            adapter.updatePokedexList(it)
        }
        viewModel.statusMsg.observe(viewLifecycleOwner){
            Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View) {

        if(v.id == R.id.btn_generation){

            GenerationsFragment().show(parentFragmentManager,"GenerationSheetDialog")

        }
        if(v.id == R.id.btn_filter){
           FiltersFragment().show(parentFragmentManager,"BottomSheetDialog")
        }
        if(v.id == R.id.btn_sort){
            SortFragment().show(parentFragmentManager,"BottomSheetDialog")
        }
    }


}