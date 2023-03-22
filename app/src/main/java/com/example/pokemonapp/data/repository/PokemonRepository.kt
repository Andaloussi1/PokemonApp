package com.example.pokemonapp.data.repository

import com.example.pokemonapp.data.dataSource.GetPokemonListDataSource
import com.example.pokemonapp.data.model.Pokemon

class PokemonRepository {

   suspend fun getPokemonList() : Pair<List<Pokemon>?,String?> =
      GetPokemonListDataSource().getPokemonList()

}