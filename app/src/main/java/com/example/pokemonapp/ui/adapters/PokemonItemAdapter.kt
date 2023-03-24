package com.example.pokemonapp.ui.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.data.model.Pokemon
import com.example.pokemonapp.databinding.PokemonItemBinding


class PokemonItemAdapter(private val pokemonList: List<Pokemon>) :
    RecyclerView.Adapter<PokemonItemAdapter.PokemonItemViewHolder>() {

    class PokemonItemViewHolder(private var binding: PokemonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.PokemonItemNameTextView.text = pokemon.name
            binding.pokemonPhoto = pokemon.getImage()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonItemViewHolder {

        return PokemonItemViewHolder(
            PokemonItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: PokemonItemViewHolder, position: Int) {
        val item = pokemonList[position]
        holder.bind(item)
    }
}
