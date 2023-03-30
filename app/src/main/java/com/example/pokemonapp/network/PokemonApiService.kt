package com.example.pokemonapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://api-pokemon-fr.vercel.app/api/v1/"

private val retrofit =
    Retrofit.Builder().addConverterFactory(ScalarsConverterFactory.create()).baseUrl(BASE_URL)
        .build()

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemons(): String

    @GET("pokemon/{pokedexId}")
    suspend fun getPokemonDetails(@Path("pokedexId") pokedexId: Int): String
}

object PokemonApi {
    val retrofitService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }
}