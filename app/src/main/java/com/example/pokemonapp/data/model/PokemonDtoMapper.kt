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
            image = pokemonDetailsDto.getImage(),
            category = pokemonDetailsDto.category,
            name = pokemonDetailsDto.name.en,
            height = pokemonDetailsDto.height,
            weight = pokemonDetailsDto.weight,
            egg_groups = pokemonDetailsDto.egg_groups,
            attack = pokemonDetailsDto.stats.atk,
            defense = pokemonDetailsDto.stats.def,
            healthPoints = pokemonDetailsDto.stats.hp,
            vitamin = pokemonDetailsDto.stats.vit

            )


    fun mapToPokemonList(listPokemonDto: List<PokemonDto>): List<Pokemon> =
        listPokemonDto.map { pokemonDto ->
            mapToPokemon(pokemonDto)
        }
}