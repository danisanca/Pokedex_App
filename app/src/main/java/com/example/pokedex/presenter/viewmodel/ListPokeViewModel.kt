package com.example.pokedex.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.domain.GetPokemonsUseCase
import com.example.pokedex.presenter.model.FilterModel
import com.example.pokedex.presenter.model.PokemonViewObject
import com.example.pokedex.presenter.model.SecurityPreferences
import com.example.pokedex.presenter.model.ViewState
import com.example.pokedex.presenter.constants.PokedexConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListPokeViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase,
    private val securityPreferences: SecurityPreferences
) : ViewModel() {

    private val _pokemonList = MutableLiveData<List<PokemonViewObject>>()
    val pokemonModel: LiveData<List<PokemonViewObject>> = _pokemonList

    private val _statusMsg = MutableLiveData<String>()
    val statusMsg: LiveData<String> = _statusMsg

    private val _filterSelected = MutableLiveData<String>()
    val filterSelected: LiveData<String> = _filterSelected

    private val _optionSelectedGeneretion = MutableLiveData<String>()
    val optionSelectedGeneretion: LiveData<String> = _optionSelectedGeneretion

    private val _optionSelectedSort = MutableLiveData<String>()
    val optionSelectedSort: LiveData<String> = _optionSelectedSort

    private val _optionsSelectedfilters = MutableLiveData<FilterModel>()
    val optionsSelectedfilters: LiveData<FilterModel> = _optionsSelectedfilters

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    fun getPokes() {
        _viewState.postValue(ViewState.LOADING)

        viewModelScope.launch(Dispatchers.IO) {
            getPokemonsUseCase().onSuccess { pokemons ->
                _pokemonList.postValue(pokemons.map { pokemon ->
                    PokemonViewObject(pokemon)
                })
                _viewState.postValue(ViewState.OK)
            }.onFailure {
                _viewState.postValue(ViewState.ERROR)
            }
            pokemonModel.value?.let { securityPreferences.store("Data", it) }
        }
    }

    fun searchPokeList(namePoke: String) {
        var newList: MutableList<PokemonViewObject> = mutableListOf()
        val old: List<PokemonViewObject> = securityPreferences.get("Data")
        _viewState.postValue(ViewState.LOADING)

        if (old != null) {
            if (namePoke != "") {

                var nameToSearch = namePoke.lowercase()

                newList = old.filter {
                    it.name == nameToSearch
                } as MutableList<PokemonViewObject>

                if (newList.isEmpty()) {
                    newList = old as MutableList<PokemonViewObject>
                }

            } else {
                newList = old as MutableList<PokemonViewObject>
            }
            _pokemonList.value = newList
            _viewState.postValue(ViewState.OK)
        }
    }

    private fun filterPokes() {
        _viewState.postValue(ViewState.LOADING)
        var newList: MutableList<PokemonViewObject> = mutableListOf()
        val old: List<PokemonViewObject> = securityPreferences.get("Data")

        if (filterSelected.value == PokedexConstants.MENUFILTER.GENERATION_OPTION) {
            if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_1) {
                old.map {
                    if (it.id <= 151) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_2) {
                old.map {
                    if (it.id in 152..251) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_3) {
                old.map {
                    if (it.id in 252..386) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_4) {
                old.map {
                    if (it.id in 387..493) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_5) {
                old.map {
                    if (it.id in 494..649) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_6) {
                old.map {
                    if (it.id in 650..721) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_7) {
                old.map {
                    if (it.id in 722..809) {
                        newList.add(it)
                    }
                }
            } else if (optionSelectedGeneretion.value == PokedexConstants.GENERATION.GEN_8) {
                old.map {
                    if (it.id >= 810) {
                        newList.add(it)
                    }
                }
            }
            _pokemonList.value = newList

        } else if (filterSelected.value == PokedexConstants.MENUFILTER.SORT_OPTION) {

            if (optionSelectedSort.value == PokedexConstants.SORT.SMALLEST) {
                newList = old as MutableList<PokemonViewObject>
            } else if (optionSelectedSort.value == PokedexConstants.SORT.HIGHEST) {
                newList = old.sortedByDescending { it.id } as MutableList<PokemonViewObject>

            } else if (optionSelectedSort.value == PokedexConstants.SORT.A_Z) {
                newList = old.sortedBy { it.name } as MutableList<PokemonViewObject>
            } else if (optionSelectedSort.value == PokedexConstants.SORT.Z_A) {
                newList = old.sortedByDescending { it.name } as MutableList<PokemonViewObject>
            }

            _pokemonList.value = newList
        } else if (filterSelected.value == PokedexConstants.MENUFILTER.FILTERS_OPTION) {
            val paramsFilter = _optionsSelectedfilters.value
            if (paramsFilter != null) {

                newList = old.filter {
                    it.id >= paramsFilter!!.rangeMin && it.id <= paramsFilter.rangeMax
                } as MutableList<PokemonViewObject>

                if (paramsFilter.weight != "") {
                    var newFilterWeigh = newList
                    var weightsConvert = pesoPokes(paramsFilter.weight)
                    var minWeight = weightsConvert[0]
                    var maxWeight = weightsConvert[1]

                    newList = newFilterWeigh.filter {
                        it.weight in minWeight..maxWeight
                    } as MutableList<PokemonViewObject>
                }
                if (paramsFilter.height != "") {
                    var newFilterHeigh = newList
                    var HeightsConvert = alturaPokes(paramsFilter.height)
                    var minHeight = HeightsConvert[0]
                    var maxHeight = HeightsConvert[1]
                    newList = newFilterHeigh.filter {
                        it.height in minHeight..maxHeight
                    } as MutableList<PokemonViewObject>
                }
                if (paramsFilter.types.isNotEmpty()) {
                    var newFiltertypesList: MutableList<PokemonViewObject> = mutableListOf()

                    newList.map { pokemonList ->
                        paramsFilter.types.map { typeList ->
                            if (typeList == pokemonList.types[0]) {
                                newFiltertypesList.add(pokemonList)
                            }
                        }
                    }
                    newList = newFiltertypesList
                }

                _pokemonList.value = newList
            }
        } else {
            _pokemonList.value = old
        }

        _viewState.postValue(ViewState.OK)
    }

    fun pesoPokes(value: String): List<Float> {
        when (value) {
            "light" -> return listOf<Float>(0f, 50f)
            "normal" -> return listOf<Float>(50.1f, 120f)
            "heavy" -> return listOf<Float>(120.1f, 5000f)
            else -> return listOf<Float>(0f)
        }
    }

    fun alturaPokes(value: String): List<Float> {
        when (value) {
            "short" -> return listOf<Float>(0f, 1.5f)
            "medium" -> return listOf<Float>(1.6f, 3.0f)
            "tall" -> return listOf<Float>(3.1f, 50.0f)
            else -> return listOf<Float>(0f)
        }
    }

    fun menuResetFilter() {
        _filterSelected.value = ""
        _optionSelectedGeneretion.value = ""
        _optionSelectedSort.value = ""
        _optionsSelectedfilters.value = FilterModel()
        filterPokes()
    }

    fun menuSelectec(idItem: String, filter: String) {
        _filterSelected.value = filter

        if (filter == PokedexConstants.MENUFILTER.GENERATION_OPTION) {
            _optionSelectedGeneretion.value = idItem
        }
        if (filter == PokedexConstants.MENUFILTER.SORT_OPTION) {
            _optionSelectedSort.value = idItem
        }
        filterPokes()
    }

    fun menuFilterSelected(filterModel: FilterModel) {
        _filterSelected.value = PokedexConstants.MENUFILTER.FILTERS_OPTION
        _optionsSelectedfilters.value = filterModel
        filterPokes()
    }

}