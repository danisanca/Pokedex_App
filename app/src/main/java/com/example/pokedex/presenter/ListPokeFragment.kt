package com.example.pokedex.presenter

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokedex.databinding.FragmentListPokeBinding
import com.example.pokedex.presenter.adapter.PokedexAdapter
import com.example.pokedex.presenter.model.PokemonViewObject
import com.example.pokedex.presenter.model.ViewState
import com.example.pokedex.presenter.viewmodel.ListPokeViewModel
import com.example.pokedex.presenter.listener.PokeListner
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListPokeFragment : Fragment() {

    private lateinit var binding: FragmentListPokeBinding
    private val viewModel: ListPokeViewModel by activityViewModels()
    private val adapter = PokedexAdapter()
    private lateinit var statePage: ViewState

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListPokeBinding.inflate(layoutInflater, container, false)

        viewModel.getPokes()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerList.layoutManager = LinearLayoutManager(context)
        binding.recyclerList.adapter = adapter
        binding.btnGeneration.setOnClickListener {
            GenerationsFragment().show(parentFragmentManager, "GenerationSheetDialog")
        }
        binding.btnFilter.setOnClickListener {
            FiltersFragment().show(parentFragmentManager, "BottomSheetDialog")
        }
        binding.btnSort.setOnClickListener {
            SortFragment().show(parentFragmentManager, "BottomSheetDialog")
        }
        val listener = object : PokeListner {
            override fun onListClick(poke: PokemonViewObject) {
                val gson = Gson()
                val listPoke = gson.toJson(poke)
                startActivity(
                    Intent(context, PokeDetailsActivity::class.java).putExtra(
                        "objPoke",
                        listPoke
                    )
                )
            }
        }
        adapter.attachListener(listener)

        binding.editSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                viewModel.searchPokeList(p0.toString())
            }
        })
        observers()
    }

    private fun observers() {

        viewModel.statusMsg.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
        viewModel.viewState.observe(viewLifecycleOwner) {
            statePage = it
            setViewState()
        }
    }

    private fun setViewState() {
        when (statePage) {
            ViewState.LOADING -> setLoadingState()
            ViewState.OK -> setOkState()
            ViewState.ERROR -> setErrorState()
        }
    }

    private fun setLoadingState() {
        binding.loading.isVisible = true
    }

    private fun setOkState() {
        binding.loading.isVisible = false
        viewModel.pokemonModel.observe(viewLifecycleOwner) {
            adapter.updatePokedexList(it)
        }
    }

    private fun setErrorState() {

        AlertDialog.Builder(requireContext()).setMessage("Erro ao tentar recuperar")
            .setPositiveButton("Tentar novamente", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    binding.loading.isVisible = true
                    viewModel.getPokes()
                }
            }).setCancelable(false)
            .show()
    }
}