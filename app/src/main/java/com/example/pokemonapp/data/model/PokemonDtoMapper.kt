package com.example.pokemonapp.data.model

import com.example.pokemonapp.domain.model.Pokemon

class PokemonDtoMapper {

    private fun mapToPokemon(pokemonDto: PokemonDto): Pokemon = Pokemon(
        id = pokemonDto.getId(), name = pokemonDto.name ?: "", image = pokemonDto.getImage()
    )


    fun mapToPokemonList(listPokemonDto: List<PokemonDto>): List<Pokemon> =
        listPokemonDto.map { pokemonDto ->
            mapToPokemon(pokemonDto)
        }
}