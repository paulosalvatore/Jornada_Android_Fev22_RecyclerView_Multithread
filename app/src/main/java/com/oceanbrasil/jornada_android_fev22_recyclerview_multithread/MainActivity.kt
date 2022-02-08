package com.oceanbrasil.jornada_android_fev22_recyclerview_multithread

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.net.URL

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

        // Exemplos de Multithread

        val url = "QUALQUER URL DE IMAGEM"

        // Estou na main thread

        val ivImagem = findViewById<ImageView>(R.id.ivImagem)

        Thread {
            // Estou na worker thread

            // Carregar a imagem (operação que pode levar um tempo)
            val imagemBitmap = carregarImagem(url)

            ivImagem.post {
                // Estou de volta na main thread
                ivImagem.setImageBitmap(imagemBitmap)
            }
        }.start()
    }

    private fun carregarImagem(urlImagem: String): Bitmap? {
        try {
            val url = URL(urlImagem)

            val conteudoUrl = url.openConnection().getInputStream()

            return BitmapFactory.decodeStream(conteudoUrl)
        } catch (e: Exception) {
            Log.e("CARREGAR_IMAGEM", "Algum erro ocorreu ao carregar a imagem.", e)

            return null
        }
    }
}
