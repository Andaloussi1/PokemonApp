package com.example.pokemonapp.data.dataSource.remote

import com.example.pokemonapp.data.model.PokemonDetailsDto
import com.example.pokemonapp.data.model.PokemonDto
import com.example.pokemonapp.network.PokemonApiService
import com.example.pokemonapp.util.Constants
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

class PokemonRemoteDataSourceImpl @Inject constructor(private val pokemonApiService: PokemonApiService) :
    PokemonRemoteDataSource {

    override suspend fun getPokemonList(): Pair<List<PokemonDto>?, String?> {
        return try {

            val response = JSONArray(pokemonApiService.getPokemons())
            val entireList = Gson().fromJson(
                response.toString(), Array<PokemonDto>::class.java
            ).asList()
            // to delete the first null element of the list
            val pokemonList = entireList.subList(1, entireList.size)
            Pair(pokemonList, null)

        } catch (e: Exception) {
            Pair(null, Constants.FAIL_RESPONSE)
        }
    }

    override suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetailsDto?, String?> {
        return try {

            val response = JSONObject(pokemonApiService.getPokemonDetails(pokemonId))
            val pokemonDetails = Gson().fromJson(
                response.toString(), PokemonDetailsDto::class.java
            )

            Pair(pokemonDetails, null)

        } catch (e: Exception) {
            Pair(null, Constants.FAIL_RESPONSE)
        }

    }
}