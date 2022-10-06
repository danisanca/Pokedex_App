package com.example.pokedex.view

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentListPokeBinding
import com.example.pokedex.service.constants.PokedexConstants
import com.example.pokedex.service.listener.PokeListner
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.view.adapter.PokeAdapter
import com.example.pokedex.viewmodel.ListPokeViewModel
import com.google.gson.Gson

class ListPokeFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentListPokeBinding
    private val viewModel:ListPokeViewModel by activityViewModels()
    private val adapter = PokeAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentListPokeBinding.inflate(layoutInflater,container,false)


        viewModel.listPokes()

        binding.recyclerList.layoutManager = LinearLayoutManager(context)
        binding.recyclerList.adapter = adapter

        binding.btnGeneration.setOnClickListener(this)
        binding.btnFilter.setOnClickListener(this)
        binding.btnSort.setOnClickListener(this)


        val listener = object : PokeListner{
            override fun onListClick(poke: PokemonModel) {
                val gson = Gson()
                val listPoke = gson.toJson(poke)
                startActivity(Intent(context,PokeDetailsActivity::class.java).putExtra("objPoke",listPoke))
            }
        }
        adapter.attachListener(listener)

        binding.editSearch.addTextChangedListener (object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {

            }

            override fun afterTextChanged(p0: Editable?) {
                viewModel.searchPokeList(p0.toString())

            }

        })

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observers()
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