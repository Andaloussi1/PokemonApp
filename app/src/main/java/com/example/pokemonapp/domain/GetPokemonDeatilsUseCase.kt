package com.example.pokemonapp.domain

import com.example.pokemonapp.data.repository.PokemonRepository
import com.example.pokemonapp.domain.model.PokemonDetails

class GetPokemonDeatilsUseCase {

    suspend fun execute(id: Int): Pair<PokemonDetails?, String?> =
        PokemonRepository().getPokemonDetails(id)
}