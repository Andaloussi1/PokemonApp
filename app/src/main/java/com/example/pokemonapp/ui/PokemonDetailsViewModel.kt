package com.example.pokemonapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.GetPokemonDeatilsUseCase
import com.example.pokemonapp.domain.model.PokemonDetails
import kotlinx.coroutines.launch

class PokemonDetailsViewModel : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    private val _pokemonDetails = MutableLiveData<PokemonDetails>()
    val pokemonDetails: LiveData<PokemonDetails> = _pokemonDetails


    fun getPokemonDetails(pokemonId: Int) {
        viewModelScope.launch {
            _loading.value = true
            val result = GetPokemonDeatilsUseCase().execute(pokemonId)
            result.first?.let { pokemonDetails ->
                _pokemonDetails.value = pokemonDetails
            } ?: run {
                _errorResponse.value = result.second!!
            }
            _loading.value = false
        }
    }

}