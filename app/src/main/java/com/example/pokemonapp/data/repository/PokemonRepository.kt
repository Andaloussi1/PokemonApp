package com.example.pokemonapp.data.repository

import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.model.PokemonDetails

interface PokemonRepository {
    suspend fun getPokemonList(): Pair<List<Pokemon>?, String?>
    suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetails?, String?>
}