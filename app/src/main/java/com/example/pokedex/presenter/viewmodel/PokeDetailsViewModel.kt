package com.example.pokedex.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class PokeDetailsViewModel : ViewModel() {
    private val _textStatus = MutableLiveData<Int>()
    val textStatus: LiveData<String> = Transformations.map(_textStatus) {
        "Status: $it"
    }
    private val _textAbout = MutableLiveData<Int>()
    val textAbout: LiveData<String> = Transformations.map(_textAbout) {
        "About: $it"
    }

    fun setIndexStatus(index: Int) {
        _textStatus.value = index
    }

    fun setIndexAbout(index: Int) {
        _textAbout.value = index
    }
}