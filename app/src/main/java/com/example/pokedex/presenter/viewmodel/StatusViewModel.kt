package com.example.pokedex.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class StatusViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val text: LiveData<String> = Transformations.map(_index) {
        "Status: $it"
    }

    fun setIndex(index: Int) {
        _index.value = index
    }
}