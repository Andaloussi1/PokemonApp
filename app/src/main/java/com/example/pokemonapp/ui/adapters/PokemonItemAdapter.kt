package com.example.pokemonapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonapp.databinding.PokemonItemBinding
import com.example.pokemonapp.domain.model.Pokemon


class PokemonItemAdapter(
    private val pokemonList: List<Pokemon>,
    private val onPokemonClicked: (Int) -> Unit
) :
    RecyclerView.Adapter<PokemonItemAdapter.PokemonItemViewHolder>() {

    class PokemonItemViewHolder(private var binding: PokemonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.pokemon = pokemon
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
        holder.itemView.setOnClickListener {
            onPokemonClicked(item.id)
        }
        holder.bind(item)
    }
}
