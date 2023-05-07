package com.example.pokemonapp.data.dataSource.remote

import com.example.pokemonapp.data.model.PokemonDetailsDto
import com.example.pokemonapp.data.model.PokemonDto

interface PokemonRemoteDataSource{
    suspend fun getPokemonList(): Pair<List<PokemonDto>?, String?>

    suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetailsDto?, String?>
}