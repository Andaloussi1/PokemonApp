package com.example.pokemonapp.network

import retrofit2.http.GET
import retrofit2.http.Path


interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemons(): String

    @GET("pokemon/{pokedexId}")
    suspend fun getPokemonDetails(@Path("pokedexId") pokedexId: Int): String
}


