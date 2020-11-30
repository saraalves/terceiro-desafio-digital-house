package com.example.marvelhq.detalhes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import com.example.marvelhq.R
import com.example.marvelhq.home.view.adapter.PersonagemAdapter
import com.example.marvelhq.home.viewmodel.ComicsViewModel
import com.example.marvelhq.model.ComicsModel
import com.example.marvelhq.repository.MarvelRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.view.*

class DetalhesActivity : AppCompatActivity() {

    private lateinit var _viewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val thumbnail = getDadosComics()
        goImageFull(thumbnail)
        viewModelProvider()
        goBack()
        showLoading(false)
    }

    private fun goImageFull(thumbnail: String?) {
        val imgThumbnail = findViewById<ImageView>(R.id.imageMiniDetalhes)
        imgThumbnail.setOnClickListener {
            val intent = Intent(this@DetalhesActivity, ImageFullActivity::class.java)
            intent.putExtra("COMICS_THUMBNAIL", thumbnail)
            startActivity(intent)
        }
    }

    private fun getDadosComics(): String? {
        val id = intent.getStringExtra("COMICS_ID")
        val titulo = intent.getStringExtra("COMICS_TITLE")
        val edicao = intent.getStringExtra("COMICS_EDITION")
        val descricao = intent.getStringExtra("COMICS_DESCRIPTION")
        val paginas = intent.getStringExtra("COMICS_PAGES")
        val data = intent.getStringExtra("COMICS_DATE")
        val preco = intent.getStringExtra("COMICS_PRECO")
        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")
        val imagem = intent.getStringExtra("COMICS_IMAGEM")


        findViewById<TextView>(R.id.txtTitleDetalhes).text = titulo
        findViewById<TextView>(R.id.txtDataPublicacao).text = edicao
        findViewById<TextView>(R.id.txtDescription).text = descricao
        findViewById<TextView>(R.id.txtPagesValue).text = paginas
        findViewById<TextView>(R.id.txtDataPublicacao).text = data
        findViewById<TextView>(R.id.txtPriceValue).text = preco


        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.imageFullDetalhes))

        Picasso.get()
            .load(thumbnail)
            .into(findViewById<ImageView>(R.id.imageMiniDetalhes))
        return thumbnail
    }

    private fun viewModelProvider() {
        _viewModel = ViewModelProvider(
            this,
            ComicsViewModel.ComicViewModelFactory(MarvelRepository())
        ).get(ComicsViewModel::class.java)
    }

    private fun goBack() {
        val goBackHome = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbarDetalhes)
        goBackHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        val viewLoading = findViewById<View>(R.id.loading)
        if (isLoading) {
            viewLoading.visibility = View.VISIBLE
        } else {
            viewLoading.visibility = View.GONE
        }
    }

}