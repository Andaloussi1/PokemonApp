package com.example.pokemonapp.domain.model

import com.example.pokemonapp.data.model.PokemonStats

data class PokemonDetails(
    val pokedexId: Int,
    val name: String,
    val image: String,
    val category: String,
    val healthPoints: Int,
    val attack: Int,
    val defense: Int,
    val vitamin : Int,
    val height: String,
    val weight: String,
    val egg_groups: List<String>
)

