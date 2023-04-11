package com.example.pokemonapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.domain.GetPokemonDetailsUseCase
import com.example.pokemonapp.domain.model.PokemonDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val getPokemonDetailsUseCase: GetPokemonDetailsUseCase
) : ViewModel() {
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorResponse = MutableLiveData<String>()
    val errorResponse: LiveData<String> = _errorResponse

    private val _pokemonDetails = MutableLiveData<PokemonDetails>()
    val pokemonDetails: LiveData<PokemonDetails> = _pokemonDetails


    fun getPokemonDetails(pokemonId: Int) {
        viewModelScope.launch {
            _loading.value = true
            val result = getPokemonDetailsUseCase.execute(pokemonId)
            result.first?.let { pokemonDetails ->
                _pokemonDetails.value = pokemonDetails
            } ?: run {
                _errorResponse.value = result.second!!
            }
            _loading.value = false
        }
    }

}