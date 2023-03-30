package com.example.pokemonapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.pokemonapp.databinding.FragmentPokemonDetailsBinding

class PokemonDetailsFragment : Fragment() {
    private val navigationArgs: PokemonDetailsFragmentArgs by navArgs()
    private val viewModel: PokemonDetailsViewModel by viewModels()
    private var _binding: FragmentPokemonDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var Hp: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonId = navigationArgs.pokemonId
        viewModel.getPokemonDetails(pokemonId)
        viewModel.pokemonDetails.value?.let { Log.d("testStats", it.stats.hp.toString()) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root

    }
}

