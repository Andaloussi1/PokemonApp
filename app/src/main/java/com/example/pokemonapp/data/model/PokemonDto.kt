package com.example.pokemonapp.data.model

const val POKEMON_IMG_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/"

data class PokemonDto(

    var pokedexId: Int, var name: PokemonName
) {

    fun getImage() = "$POKEMON_IMG_URL${pokedexId}.svg"
}

