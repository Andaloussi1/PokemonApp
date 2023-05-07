package com.example.pokemonapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokemonapp.databinding.FragmentDetailsWebviewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsWebViewFragment : Fragment() {
    private val navigationArgs: DetailsWebViewFragmentArgs by navArgs()
    private var _binding: FragmentDetailsWebviewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsWebviewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pokemonName = navigationArgs.pokemonName

        binding.DetailsWebView.loadUrl("https://www.pokemon.com/us/pokedex/$pokemonName")
        binding.DetailsWebView.settings.apply {
            javaScriptEnabled = true
            setSupportZoom(true)
            domStorageEnabled = true
        }
    }
}