package com.example.pokemonapp.domain

import com.example.pokemonapp.data.repository.PokemonRepository
import com.example.pokemonapp.domain.model.PokemonDetails
import javax.inject.Inject


class GetPokemonDetailsUseCase
@Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend fun execute(id: Int): Pair<PokemonDetails?, String?> =
        pokemonRepository.getPokemonDetails(id)
}