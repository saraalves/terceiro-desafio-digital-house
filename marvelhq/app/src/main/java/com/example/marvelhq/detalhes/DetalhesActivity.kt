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
import com.example.marvelhq.home.viewmodel.ComicsViewModel
import com.example.marvelhq.repository.MarvelRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.view.*

class DetalhesActivity : AppCompatActivity() {

    private lateinit var _viewModel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val id = intent.getStringExtra("COMICS_ID")
        val descricao = intent.getStringExtra("COMICS_DESCRIPTION")
        val titulo = intent.getStringExtra("COMICS_TITLE")
        val paginas = intent.getStringExtra("COMICS_PAGES")
        val edicao = intent.getStringExtra("COMICS_EDITION")
        val imagem = intent.getStringExtra("COMICS_IMAGEM")
        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")
        val preco = intent.getStringExtra("COMICS_PRECO")


        findViewById<TextView>(R.id.txtTitleDetalhes).text = titulo
        findViewById<TextView>(R.id.txtDescription).text = descricao
        findViewById<TextView>(R.id.txtDataPublicacao).text = edicao
        findViewById<TextView>(R.id.txtPriceValue).text = preco
        findViewById<TextView>(R.id.txtPagesValue).text = paginas

        Picasso.get()
            .load(imagem)
            .into(findViewById<ImageView>(R.id.imageFullDetalhes))

        Picasso.get()
            .load(thumbnail)
            .into(findViewById<ImageView>(R.id.imageMiniDetalhes))

        viewModelProvider()
        goBack()
        setNavigationImageFull()
        showLoading(false)
    }

    private fun viewModelProvider() {
        _viewModel = ViewModelProvider(
            this,
            ComicsViewModel.ComicViewModelFactory(MarvelRepository())
        ).get(ComicsViewModel::class.java)
    }

    private fun setNavigationImageFull() {
        val imgThumbnail = findViewById<ImageView>(R.id.imageMiniDetalhes)
        imgThumbnail.setOnClickListener {
            val intent = Intent(this@DetalhesActivity, ImageFullActivity::class.java)
    //            intent.putExtra("IMAGEM", it.imageMiniDetalhes)
            startActivity(intent)
        }
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