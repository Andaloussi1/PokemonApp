package com.example.pokemonapp.data.dataSource

import com.example.pokemonapp.data.model.Pokemon
import com.example.pokemonapp.network.PokemonApi
import com.example.pokemonapp.util.Constants.FAIL_RESPONSE
import com.google.gson.Gson
import org.json.JSONObject

class GetPokemonListDataSource {

    suspend fun getPokemonList() : Pair<List<Pokemon>?,String?> {
        return try {

            val response = JSONObject(PokemonApi.retrofitService.getPokemons())
                .getString("results")
            val pokenmonList = Gson().fromJson(response.toString(),
                Array<Pokemon>::class.java).asList()
            Pair(pokenmonList, null)

        } catch (e:Exception){
            Pair(null, FAIL_RESPONSE)
        }
    }
}