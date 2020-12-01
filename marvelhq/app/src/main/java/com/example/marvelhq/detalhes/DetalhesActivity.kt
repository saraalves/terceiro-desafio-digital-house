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
import com.example.marvelhq.model.DatesModel
import com.example.marvelhq.model.PrecosModel
import com.example.marvelhq.model.ThumbnailModel
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

    private fun getDadosComics(): String? {
        val id = intent.getStringExtra("COMICS_ID")
        val titulo = intent.getStringExtra("COMICS_TITLE")
        val descricao = intent.getStringExtra("COMICS_DESCRIPTION")
        val paginas = intent.getStringExtra("COMICS_PAGES")
        val dataPublicacao = intent.getStringExtra("COMICS_EDITION")
        val preco = intent.getStringExtra("COMICS_PRECO")
        val thumbnail = intent.getStringExtra("COMICS_THUMBNAIL")
        val imagem = intent.getStringExtra("COMICS_IMAGEM")


        findViewById<TextView>(R.id.txtTitleDetalhes).text = titulo
        val txtDataPublicacao = findViewById<TextView>(R.id.txtDataPublicacao)
        val txtDescription = findViewById<TextView>(R.id.txtDescription)
        findViewById<TextView>(R.id.txtPagesValue).text = paginas
        val txtPriceValue = findViewById<TextView>(R.id.txtPriceValue)
        val imageFullDetalhes = findViewById<ImageView>(R.id.imageFullDetalhes)

        if(descricao != null){
            txtDescription.text = descricao
        }
        if (dataPublicacao != null){
            for (date in dataPublicacao as List<DatesModel>){
                var calendar = Calendar.getInstance()
                calendar.time = date.data!!
                txtDataPublicacao.text = calendar.getDisplayName(
                    Calendar.MONTH,
                    Calendar.LONG,
                    Locale.getDefault()
                ) + " " + calendar.get(Calendar.DAY_OF_MONTH) + ", " + calendar.get(Calendar.YEAR)
            }
        }

        if (preco != null) {
            txtPriceValue.text = "$ ${(preco as List<PrecosModel>)[0].preco.toString()}"
        }

        if (imagem != null) {
            Picasso.get()
                .load(
                    (imagem as List<ThumbnailModel>)[(imagem as List<ThumbnailModel>).size - 1]
                        .getImagePath("imageFullDetalhes")
                )
                .into(imageFullDetalhes)
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