package com.example.pokemonapp.ui.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.pokemonapp.MainCoroutineRule
import com.example.pokemonapp.data.repository.FakePokemonRepositoryImpl
import com.example.pokemonapp.domain.GetPokemonListUseCase
import com.example.pokemonapp.getOrAwaitValueTest
import com.example.pokemonapp.ui.PokemonListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class PokemonListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: PokemonListViewModel

    @Before
    fun setup() {
        viewModel = PokemonListViewModel(GetPokemonListUseCase(FakePokemonRepositoryImpl()))
    }

    @Test
    fun get_pokemon_list() {
        val pokemonListSize = viewModel.pokemons.getOrAwaitValueTest().size
        assertEquals(3, pokemonListSize)
    }
}