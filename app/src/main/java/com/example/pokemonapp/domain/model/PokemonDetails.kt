package com.example.pokemonapp.domain.model

import com.example.pokemonapp.data.model.PokemonStats

data class PokemonDetails(
    val pokedexId: Int,
    val name: String,
    val category: String,
    val stats: PokemonStats,
    val height: String,
    val weight: String,
    val egg_groups: List<String>
)

