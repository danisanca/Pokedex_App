package com.example.pokedex.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.example.pokedex.service.constants.PokedexConstants
import com.example.pokedex.service.listener.APIListener
import com.example.pokedex.service.model.FilterModel
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.service.repository.PokemonRepository

class ListPokeViewModel:ViewModel() {

    private val pokemonRepository = PokemonRepository()

    private val _pokemonModel = MutableLiveData<List<PokemonModel>>()
    val pokemonModel:LiveData<List<PokemonModel>> = _pokemonModel

    private val _statusMsg = MutableLiveData<String>()
    val statusMsg:LiveData<String> = _statusMsg

    private val _filterSelected = MutableLiveData<String>()
    val filterSelected:LiveData<String> = _filterSelected

    private val _optionSelectedGeneretion = MutableLiveData<String>()
    val optionSelectedGeneretion:LiveData<String> = _optionSelectedGeneretion

    private val _optionSelectedSort = MutableLiveData<String>()
    val optionSelectedSort:LiveData<String> = _optionSelectedSort

    private val _optionsSelectedfilters = MutableLiveData<FilterModel>()
    val optionsSelectedfilters:LiveData<FilterModel> = _optionsSelectedfilters

    //


    fun listPokes(){
       pokemonRepository.list(object : APIListener<List<PokemonModel>>{
           override fun onSuccess(result: List<PokemonModel>) {
               _pokemonModel.value = result
           }

           override fun onFailure(message: String) {
               _statusMsg.value = message
           }

       })

    }

    fun menuSelectec(idItem:String,filter:String){
        _filterSelected.value = filter

        if(filter == PokedexConstants.MENUFILTER.GENERATION_OPTION){
            _optionSelectedGeneretion.value = idItem
        }
        if(filter == PokedexConstants.MENUFILTER.SORT_OPTION){
            _optionSelectedSort.value = idItem
        }

    }
    fun menuFilterSelected(filterModel:FilterModel){
        _filterSelected.value = PokedexConstants.MENUFILTER.FILTERS_OPTION
        _optionsSelectedfilters.value = filterModel

        println(filterModel)

    }

}