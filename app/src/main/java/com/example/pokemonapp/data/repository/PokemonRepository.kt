package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.dataSource.GetPokemonListDataSource
import com.example.pokemonapp.data.model.PokemonDtoMapper
import com.example.pokemonapp.domain.model.Pokemon

class PokemonRepository {

    suspend fun getPokemonList(): Pair<List<Pokemon>?, String?> {

        val result = GetPokemonListDataSource().getPokemonList()

        return result.first?.let { pokemonDtoList ->
            Pair(PokemonDtoMapper().mapToPokemonList(pokemonDtoList), null)

        } ?: run {
            Pair(null, result.second)

        }
    }


}