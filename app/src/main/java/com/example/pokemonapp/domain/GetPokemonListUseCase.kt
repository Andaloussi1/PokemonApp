package com.example.pokemonapp.domain

import com.example.pokemonapp.data.repository.PokemonRepository
import com.example.pokemonapp.domain.model.Pokemon

class GetPokemonListUseCase {

    suspend fun execute(): Pair<List<Pokemon>?, String?> = PokemonRepository().getPokemonList()
}