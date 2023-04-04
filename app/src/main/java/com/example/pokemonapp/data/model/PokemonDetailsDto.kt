package com.example.pokemonapp.data.model

import com.example.pokemonapp.util.Constants.POKEMON_IMG_URL


data class PokemonDetailsDto(

    val pokedexId: Int,
    val name: PokemonName,
    val category: String,
    val stats: PokemonStats,
    val height: String,
    val weight: String,
    val egg_groups: List<String>

) {
    fun getImage() = "$POKEMON_IMG_URL$pokedexId.svg"
}

