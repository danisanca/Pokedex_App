package com.example.pokedex.service.repository


import com.example.pokedex.service.listener.APIListener
import com.example.pokedex.service.model.PokemonModel
import com.example.pokedex.service.repository.remote.PokemonService
import com.example.pokedex.service.repository.remote.RetrofitClient
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonRepository() {
    private val remote = RetrofitClient.getService(PokemonService::class.java)

     fun list(listener:APIListener<List<PokemonModel>>){
        val call = remote.list()
        call.enqueue(object : Callback<List<PokemonModel>>{
            override fun onResponse(call: Call<List<PokemonModel>>,response: Response<List<PokemonModel>>) {
              if(response.code() == 200){
                  response.body()?.let { listener.onSuccess(it) }
              }else{
                  listener.onFailure(failResponse(response.errorBody()!!.string()))
              }
            }
            override fun onFailure(call: Call<List<PokemonModel>>, t: Throwable) {
                listener.onFailure("Erro Inesperado")
            }
        })
    }

    private fun failResponse(str:String):String{
        return Gson().fromJson(str,String::class.java)
    }

}