package com.example.pokemonapp.data.model

import com.example.pokemonapp.util.Constants.POKEMON_IMG_URL


data class PokemonDto(
    var pokedexId: Int,
    var name: PokemonName
) {

    fun getImage() = "$POKEMON_IMG_URL$pokedexId.svg"
}

