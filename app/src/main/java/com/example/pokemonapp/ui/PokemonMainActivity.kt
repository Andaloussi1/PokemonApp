package com.example.pokemonapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.pokemonapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PokemonMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navPokemonDetails(pokemonId: Int) {
        val action =
            PokemonListFragmentDirections.actionPokemonListFragmentToPokemonDetailsFragment(
                pokemonId
            )
        findNavController(R.id.nav_host_fragment).navigate(action)
    }
}