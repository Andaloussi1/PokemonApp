package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.dataSource.remote.PokemonRemoteDataSource
import com.example.pokemonapp.data.model.PokemonDtoMapper
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.model.PokemonDetails
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val pokemonDataSource: PokemonRemoteDataSource) :
    PokemonRepository {

    override suspend fun getPokemonList(): Pair<List<Pokemon>?, String?> {
        val result = pokemonDataSource.getPokemonList()

        return result.first?.let { pokemonDtoList ->
            Pair(PokemonDtoMapper().mapToPokemonList(pokemonDtoList), null)

        } ?: run {
            Pair(null, result.second)

        }
    }

    override suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetails?, String?> {

        val result = pokemonDataSource.getPokemonDetails(pokemonId)

        return result.first?.let { pokemonDetails ->
            Pair(PokemonDtoMapper().mapToPokemonDetails(pokemonDetails), null)

        } ?: run {
            Pair(null, result.second)

        }
    }


}