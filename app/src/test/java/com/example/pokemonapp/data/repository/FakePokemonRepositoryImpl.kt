package com.example.pokemonapp.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.pokemonapp.domain.model.Pokemon
import com.example.pokemonapp.domain.model.PokemonDetails

class FakePokemonRepositoryImpl : PokemonRepository {

    // favoritePokemonList for testing the the local favorite pokemon list
    private val favoritePokemonList = mutableListOf<Pokemon>()
    private val favoritePokemonListLiveData = MutableLiveData<List<Pokemon>>(favoritePokemonList)

    //
    private val pokemonList = listOf(
        Pokemon(
            1,
            "Bulbasaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg"
        ),
        Pokemon(
            2,
            "Ivysaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/2.svg"
        ),
        Pokemon(
            3,
            "Venusaur",
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/3.svg"
        )

    )

    override suspend fun getPokemonList(): Pair<List<Pokemon>?, String?> {
        return Pair(pokemonList, null)
    }

    override suspend fun getPokemonDetails(pokemonId: Int): Pair<PokemonDetails?, String?> {
        return Pair(
            PokemonDetails(
                pokedexId = 1,
                name = "Bulbasaur",
                image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/1.svg",
                category = "Pokémon Graine",
                healthPoints = 45,
                attack = 49,
                defense = 49,
                vitamin = 45,
                height = "0,7 m",
                weight = "6,9 kg",
                egg_groups = listOf("Monstrueux", "Végétal")
            ), null
        )
    }
}