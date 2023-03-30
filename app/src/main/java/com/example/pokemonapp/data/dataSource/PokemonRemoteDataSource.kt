package com.example.pokemonapp.data.dataSource

import com.example.pokemonapp.data.model.PokemonDetailsDto
import com.example.pokemonapp.data.model.PokemonDto
import com.example.pokemonapp.network.PokemonApi
import com.example.pokemonapp.util.Constants
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject

class PokemonRemoteDataSource {

    suspend fun getPokemonList(): Pair<List<PokemonDto>?, String?> {
        return try {

            val response = JSONArray(PokemonApi.retrofitService.getPokemons())
            val entireList = Gson().fromJson(
                response.toString(), Array<PokemonDto>::class.java
            ).asList()
            // to retrieve the first null element in the list
            val pokenmonList = entireList.subList(1, entireList.size)
            Pair(pokenmonList, null)

        } catch (e: Exception) {
            Pair(null, Constants.FAIL_RESPONSE)
        }
    }

    suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetailsDto?, String?> {
        return try {

            val response = JSONObject(PokemonApi.retrofitService.getPokemonDetails(pokemonId))
            val pokemonDetails = Gson().fromJson(
                response.toString(), PokemonDetailsDto::class.java
            )

            Pair(pokemonDetails, null)

        } catch (e: Exception) {
            Pair(null, Constants.FAIL_RESPONSE)
        }

    }
}