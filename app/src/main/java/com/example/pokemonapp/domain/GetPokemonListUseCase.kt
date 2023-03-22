package com.example.pokemonapp.domain

import com.example.pokemonapp.data.model.Pokemon
import com.example.pokemonapp.data.repository.PokemonRepository

class GetPokemonListUseCase {

    suspend fun execute() : Pair<List<Pokemon>?,String?> = PokemonRepository().getPokemonList()
}