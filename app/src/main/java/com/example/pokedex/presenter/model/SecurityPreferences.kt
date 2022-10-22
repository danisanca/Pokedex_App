package com.example.pokedex.presenter.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SecurityPreferences(private val context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("pokedexShared", Context.MODE_PRIVATE)

    fun store(key: String, value: List<PokemonViewObject>) {
        val gson = Gson()
        val json: String = gson.toJson(value)

        preferences.edit().putString(key, json).apply()
    }

    fun remove(key: String) {
        preferences.edit().remove(key).apply()
    }

    fun get(key: String): List<PokemonViewObject> {
        val gson = Gson()
        val type = object : TypeToken<ArrayList<PokemonViewObject>>() {}.type
        val json: String? = preferences.getString(key, null)
        return gson.fromJson(json, type)
    }

}