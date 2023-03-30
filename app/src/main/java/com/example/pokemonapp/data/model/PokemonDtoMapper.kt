package com.example.pokemonapp.data.model

import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.model.PokemonDetails

class PokemonDtoMapper {

    private fun mapToPokemon(pokemonDto: PokemonDto): Pokemon = Pokemon(

        id = pokemonDto.pokedexId,
        name = pokemonDto.name.en,
        image = pokemonDto.getImage()
    )

    fun mapToPokemonDetails(pokemonDetailsDto: PokemonDetailsDto): PokemonDetails =
        PokemonDetails(
            pokedexId = pokemonDetailsDto.pokedexId,
            category = pokemonDetailsDto.category,
            name = pokemonDetailsDto.name.en,
            stats = pokemonDetailsDto.stats,
            height = pokemonDetailsDto.height,
            weight = pokemonDetailsDto.weight,
            egg_groups = pokemonDetailsDto.egg_groups,

            )


    fun mapToPokemonList(listPokemonDto: List<PokemonDto>): List<Pokemon> =
        listPokemonDto.map { pokemonDto ->
            mapToPokemon(pokemonDto)
        }
}