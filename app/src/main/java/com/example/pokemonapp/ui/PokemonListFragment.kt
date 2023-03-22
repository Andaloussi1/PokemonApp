package com.example.pokemonapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonListBinding


class PokemonListFragment : Fragment() {

    private var _binding: FragmentPokemonListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PokemonListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonListBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    fun initObservers() {

        viewModel.loading.observe(viewLifecycleOwner) { loadingStatus ->
            if (loadingStatus) {
                binding.loaderImg.visibility = View.VISIBLE
            } else {
                binding.loaderImg.visibility = View.GONE
            }
        }

        viewModel.pokemons.observe(viewLifecycleOwner) { pokemonList ->
            binding.dataStatus.text = resources.getString(R.string.data_loaded_successfully)
            Log.d("listPok", pokemonList.toString())
        }

        viewModel.errorResponse.observe(viewLifecycleOwner) { error ->
            binding.dataStatus.text = resources.getString(R.string.fail_to_load_data)
        }
    }


}