package com.example.pokemonapp.domain

import com.example.pokemonapp.data.repository.PokemonRepository
import com.example.pokemonapp.domain.model.Pokemon
import javax.inject.Inject

class GetPokemonListUseCase
@Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun execute(): Pair<List<Pokemon>?, String?> =
        pokemonRepository.getPokemonList()
}