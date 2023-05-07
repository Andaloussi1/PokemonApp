package com.example.pokemonapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentPokemonDetailsBinding
import com.example.pokemonapp.domain.model.PokemonDetails
import com.example.pokemonapp.util.bindImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsFragment : Fragment() {
    private val navigationArgs: PokemonDetailsFragmentArgs by navArgs()
    private val viewModel: PokemonDetailsViewModel by viewModels()
    private var _binding: FragmentPokemonDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPokemonDetailsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonId = navigationArgs.pokemonId
        viewModel.getPokemonDetails(pokemonId)

        binding.WebFloatingButton.setOnClickListener {
            viewModel.pokemonDetails.value?.let { pokemonName ->
                (requireActivity() as PokemonMainActivity).openPokemonDetailsWebView(
                    pokemonName.name
                )
            }
        }
        initObservers()

    }


    private fun initObservers() {


        viewModel.loading.observe(viewLifecycleOwner) { loadingStatus ->
            if (loadingStatus) {
                binding.loaderImg.visibility = View.VISIBLE
            } else {
                binding.loaderImg.visibility = View.GONE
            }
        }

        viewModel.pokemonDetails.observe(viewLifecycleOwner) { pokemonDetails ->
            bindingPokemonDetails(pokemonDetails)
        }

        viewModel.errorResponse.observe(viewLifecycleOwner) {
            binding.dataStatus.text = getString(R.string.fail_to_load_data)
        }
    }

    private fun bindingPokemonDetails(pokemonDetails: PokemonDetails) {
        binding.apply {
            pokemonNameTextView.text = pokemonDetails.name
            pokemonCategoryTextView.text = pokemonDetails.category

            pokemonDefenseTextView.text = pokemonDetails.defense.toString()
            pokemonAttackTextView.text = pokemonDetails.attack.toString()
            pokomenHealthPointsTextView.text = pokemonDetails.healthPoints.toString()
            pokemonVitaminTextView.text = pokemonDetails.vitamin.toString()

            pokemonDefenseProgressBar.progress = pokemonDetails.defense
            pokemonAttackProgressBar.progress = pokemonDetails.attack
            pokemonVitaminProgressBar.progress = pokemonDetails.vitamin
            pokemonHealthPointsProgressBar.progress = pokemonDetails.healthPoints

            pokemonHeightTextView.text = getString(R.string.height, pokemonDetails.height)
            pokemonWeightTextView.text = getString(R.string.weight, pokemonDetails.weight)

            dataStatus.visibility = View.GONE
        }

        bindImage(binding.pokemonImage, pokemonDetails.image)
    }


}