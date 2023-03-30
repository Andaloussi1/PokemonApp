package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.dataSource.PokemonRemoteDataSource
import com.example.pokemonapp.data.model.PokemonDtoMapper
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.model.PokemonDetails

class PokemonRepository {

    suspend fun getPokemonList(): Pair<List<Pokemon>?, String?> {

        val result = PokemonRemoteDataSource().getPokemonList()

        return result.first?.let { pokemonDtoList ->
            Pair(PokemonDtoMapper().mapToPokemonList(pokemonDtoList), null)

        } ?: run {
            Pair(null, result.second)

        }
    }

    suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetails?, String?> {

        val result = PokemonRemoteDataSource().getPokemonDetails(pokemonId)

        return result.first?.let { pokemonDetails ->
            Pair(PokemonDtoMapper().mapToPokemonDetails(pokemonDetails), null)

        } ?: run {
            Pair(null, result.second)

        }
    }


}