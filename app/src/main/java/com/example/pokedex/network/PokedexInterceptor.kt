package com.example.pokedex.network

import com.example.pokedex.network.exception.NoNetworkConnectionException
import okhttp3.Interceptor
import okhttp3.Response

class PokedexInterceptor(private val checkNetworkConnection:CheckNetworkConnection):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if(checkNetworkConnection.isAvaiable()){
            return chain.proceed(
                chain.request().newBuilder()
                    .build()
            )
        }else{
            throw NoNetworkConnectionException()
        }
    }

}