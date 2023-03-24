package com.example.pokemonapp.data.model


data class Pokemon(
    var name: String? = null, var url: String? = null
) {
    fun getId() = url?.split("/")?.last { it.isNotBlank() } ?: "0"

    fun getImage() =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${getId()}.svg"
}