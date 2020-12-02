package com.example.marvelhq.detalhes

import android.annotation.SuppressLint
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
import com.example.marvelhq.model.*
import com.example.marvelhq.repository.MarvelRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhes.view.*
import java.util.*

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

    @SuppressLint("SetTextI18n")
    private fun getDadosComics(): String? {
        val id = intent.getStringExtra("COMICS_ID")
        val titulo = intent.getStringExtra("COMICS_TITLE")
        val descricao = intent.getStringExtra("COMICS_DESCRIPTION")
        val paginas = intent.getIntExtra("COMICS_PAGES", 0)
        val dataPublicacao = intent.getStringExtra("COMICS_DATE")
        val preco = intent.getFloatExtra("COMICS_PRECO", 0f)
        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")


        findViewById<TextView>(R.id.txtTitleDetalhes).text = titulo
        findViewById<TextView>(R.id.txtDataPublicacao).text = dataPublicacao
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        findViewById<TextView>(R.id.txtPagesValue).text = paginas.toString()
        findViewById<TextView>(R.id.txtPriceValue).text = "$ ${preco.toString()}"

        if (descricao != null) {
            txtDescription.text = descricao
        }

        Picasso.get().load(thumbnail).into(findViewById<ImageView>(R.id.imageMiniDetalhes))

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