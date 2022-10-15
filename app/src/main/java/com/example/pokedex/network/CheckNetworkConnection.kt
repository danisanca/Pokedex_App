package com.example.pokedex.network

import android.content.Context
import android.net.ConnectivityManager

class CheckNetworkConnection(private val context: Context) {

    fun isAvaiable():Boolean{
        val connectionMananger = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connectionMananger.getNetworkCapabilities(connectionMananger.activeNetwork)!=null
    }
}