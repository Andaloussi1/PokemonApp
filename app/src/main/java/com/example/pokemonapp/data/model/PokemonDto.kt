package com.example.pokemonapp.data.model

const val POKEMON_IMG_URL =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/"

data class PokemonDto(
    var name: String? = null, var url: String? = null
) {
    fun getId() = url?.split("/")?.last { it.isNotBlank() } ?: "0"

    fun getImage() =
        "$POKEMON_IMG_URL${getId()}.svg"
}

