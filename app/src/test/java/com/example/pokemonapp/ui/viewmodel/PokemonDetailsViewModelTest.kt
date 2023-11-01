package com.example.pokemonapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokemonapp.MainCoroutineRule
import com.example.pokemonapp.data.repository.FakePokemonRepositoryImpl
import com.example.pokemonapp.domain.GetPokemonDetailsUseCase
import com.example.pokemonapp.getOrAwaitValueTest
import com.example.pokemonapp.ui.PokemonDetailsViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonDetailsViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: PokemonDetailsViewModel

    @Before
    fun setup() {
        viewModel = PokemonDetailsViewModel(GetPokemonDetailsUseCase(FakePokemonRepositoryImpl()))
    }

    @Test
    fun get_pokemon_details() {
        viewModel.getPokemonDetails(1)
        val pokemonListSize = viewModel.pokemonDetails.getOrAwaitValueTest()
        Assert.assertEquals("Bulbasaur", pokemonListSize.name)
    }
}