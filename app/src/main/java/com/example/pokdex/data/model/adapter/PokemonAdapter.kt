package com.example.pokdex.data.model.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokdex.R
import com.example.pokdex.core.Constants
import com.example.pokdex.data.model.PokemonModel
import com.example.pokdex.domain.model.Pokemon
import com.example.pokdex.ui.view.PokemonActivity

class PokemonAdapter(private val listPokemonModels: List<Pokemon>) :
    RecyclerView.Adapter<PokemonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PokemonViewHolder(layoutInflater.inflate(R.layout.item_pokemon, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val pokemonCurrent = listPokemonModels[position]
        holder.render(pokemonCurrent)
        holder.itemView.setOnClickListener {
            goToItemPokemon(
                pokemonCurrent, holder.itemView.context
            )
        }
    }

    override fun getItemCount(): Int = listPokemonModels.size

    private fun goToItemPokemon(pokemon: Pokemon, context: Context) {
        val intent = Intent(context, PokemonActivity::class.java)
        intent.putExtra(Constants.POKEMON_KEY, pokemon)
        context.startActivity(intent)
    }

}