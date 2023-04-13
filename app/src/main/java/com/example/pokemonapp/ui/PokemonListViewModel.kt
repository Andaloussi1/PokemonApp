package com.example.pokemonapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.GetPokemonListUseCase
import com.example.pokemonapp.domain.model.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val pokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    private val _pokemons = MutableLiveData<List<Pokemon>>()
    val pokemons: LiveData<List<Pokemon>> = _pokemons


    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            _loading.value = true
            val result = pokemonListUseCase.execute()
            result.first?.let { pokemonList ->
                _pokemons.value = pokemonList
            } ?: run {
                _errorResponse.value = result.second!!
            }
            _loading.value = false
        }
    }

}