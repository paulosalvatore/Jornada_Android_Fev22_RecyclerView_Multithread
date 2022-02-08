package com.oceanbrasil.jornada_android_fev22_recyclerview_multithread

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rvPokemons = findViewById<RecyclerView>(R.id.rvPokemons)

        // Layout Manager
        rvPokemons.layoutManager = LinearLayoutManager(this)

        // Adapter
        val charmander = Pokemon(
            "Charmander",
            "https://sm.ign.com/ign_br/screenshot/default/blob_bkmv.jpg"
        )

        val pikachu = Pokemon(
            "Pikachu",
            "https://cidadedoheroi.com.br/wp-content/uploads/2021/11/Pikachu-capa.jpg"
        )

        val listaPokemons = listOf(charmander, pikachu)

        rvPokemons.adapter = PokemonsAdapter(listaPokemons)
    }
}
