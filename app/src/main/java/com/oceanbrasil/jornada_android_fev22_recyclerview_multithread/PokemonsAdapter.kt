package com.oceanbrasil.jornada_android_fev22_recyclerview_multithread

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

data class Pokemon(val nome: String, val imagemUrl: String)

class PokemonsAdapter(val itens: List<Pokemon>) : RecyclerView.Adapter<PokemonsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}
